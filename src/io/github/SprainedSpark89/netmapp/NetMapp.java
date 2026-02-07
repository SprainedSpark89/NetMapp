/**
 * 
 */
package io.github.SprainedSpark89.netmapp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.Utils;
import io.github.SprainedSpark89.netmapp.version.base.VersionRegisterHook;
import io.github.SprainedSpark89.netmapp.version.base.Versions;

/**
 * 
 */
public class NetMapp {

	public ServerSocketChannel sSC;
	
	public boolean isRunning;
	public Logger log;
	public static List<Thread> networkingThreads = new ArrayList<Thread>();
	
	public static Versions connectedVersion;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Creating New Instance...");
		// allow overriding target via args: host port
		new NetMapp();
	}

	public NetMapp() throws IOException {
		(new VersionRegisterHook()).registerVersions();
		log = Logger.getLogger("NetMapp");
		makeNetworkThread("C0.0.15a Thread", 5565, "TCP");

	}

	public void makeNetworkThread(String name, int port, String connectionType) throws IOException {
		if(connectionType.contentEquals("TCP")) {
			System.out.println("Opening TCP Networking Socket...");
			sSC = ServerSocketChannel.open();
			sSC.socket().bind(new InetSocketAddress(port));
			System.out.println("Done!");

			System.out.println("Making Thread");
			int currentThreadID = networkingThreads.size(); 
			networkingThreads.add(new Thread(() -> {
				System.out.println("Started Thread!");
				this.isRunning = true;
				try {
					while (this.isRunning) {
						System.out.println("Waiting for Connection...");
						final SocketChannel accept = sSC.accept();
						if (accept == null) {
							// non-blocking accept; yield briefly
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								Thread.currentThread().interrupt();
							}
						}
						System.out.println("Got Connection! " + accept.getRemoteAddress());

						// Handle the connection in its own thread
						final SocketChannel clientChannel = accept;
						new Thread(() -> {
							try {
								SocketChannel ch = clientChannel;
								System.out.println("Handling client " + ch.getRemoteAddress());
								ByteBuffer buf = ByteBuffer.allocate(8192);
								while (ch.isOpen()) {
									int read = ch.read(buf);
									if (read > 0) {
										buf.flip();
										byte[] data = new byte[buf.remaining()];
										buf.get(data);
										getConnectedTCPVersion(data);
										Packet packet = Utils.getPacketFromID(data[0], connectedVersion);
										log.info("Connected Version is " + connectedVersion.version + "\n" +
										byteArrayToString(data) + "\nHex: " + bytesToHex(data) + "\n"
												+ packet.getClass().getSimpleName() + "\nData: "
												+ parsePacket(packet, data));
										
										
										buf.clear();
									} else if (read == -1) {
										System.out.println("Client closed connection: " + ch.getRemoteAddress());
										try {
											ch.close();
										} catch (IOException e) {
											/* ignore */ }
										break;
									} else {
										// no data available; avoid busy spin
										try {
											Thread.sleep(50);
										} catch (InterruptedException e) {
											Thread.currentThread().interrupt();
											break;
										}
									}
								}
							} catch (IOException e) {
								System.err.println("Connection handler IO error: " + e);
								e.printStackTrace();
							}
						}, "NetMapp-Client-" + name).start();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}, name));
			System.out.println("Done!\nStarting Thread...");
			networkingThreads.get(currentThreadID).start();
		}
	}
	
	public String parsePacket(Packet packet, byte[] data) {
		int pos = 0;
		String out = "";
		out += "PacketID: " + packet.packetID + ", Data: ";
		pos++; // skip the packet id
		for(Class<?> clazz : packet.args) {
			if(clazz == Long.TYPE) {
				out += "Long: ";
				for(int i = 0; i < Long.BYTES; i++) {
					out += data[pos + i];
				}
				out += ", ";
				pos += Long.BYTES;
			} else if(clazz == Short.TYPE) {
				out += "Short: ";
				for(int i = 0; i < Short.BYTES; i++) {
					out += data[pos + i];
				}
				out += ", ";
				pos += Short.BYTES;
			} else if(clazz == Byte.TYPE) {
				out += "Byte: ";
				for(int i = 0; i < Byte.BYTES; i++) {
					out += data[pos + i];
				}
				out += ", ";
				pos += Byte.BYTES;
			} else if(clazz == Double.TYPE) {
				out += "Double: ";
				for(int i = 0; i < Double.BYTES; i++) {
					out += data[pos + i];
				}
				out += ", ";
				pos += Double.BYTES;
			} else if(clazz == Float.TYPE) {
				out += "Float: ";
				for(int i = 0; i < Float.BYTES; i++) {
					out += data[pos + i];
				}
				out += ", ";
				pos += Float.BYTES;
			} else if(clazz == byte[].class) {
				out += "Byte Array: ";
				for(int i = 0; i < 1024; i++) {
					out += data[pos + i];
				}
				out += ", ";
				pos += 1024;
			} else if(clazz == String.class) {
				out += "String: ";
				for(int i = 0; i < 64; i++) { // go through 64 bytes
					out += (char)data[pos + i];
				}
				out += ", ";
				pos += 64;
			} else {
				out += "Unknown Class, ";
			}
		}
		
		return out.replaceAll(".*,\\s*$", "");
	}

	public void getConnectedTCPVersion(byte[] packetData) {
		List<Packet> loginPackets = Utils.getLoginPackets(Utils.getTCPVersions());
		for(Packet packet : loginPackets) {
			if(packetData[0] == packet.packetID) { // byte checksum checking to try to find a match
				// classic strings are always 64 bytes, just with padding
				int pCS = 0; // first classic check
				pCS++; // packet id is 1 byte
				for(Class<?> clazz : packet.args) {
					if(clazz == Long.TYPE) {
						pCS += Long.BYTES;
					} else if(clazz == Short.TYPE) {
						pCS += Short.BYTES;
					} else if(clazz == Byte.TYPE) {
						pCS += Byte.BYTES;
					} else if(clazz == Double.TYPE) {
						pCS += Double.BYTES;
					} else if(clazz == Float.TYPE) {
						pCS += Float.BYTES;
					} else if(clazz == byte[].class) {
						pCS += 1024;
					} else if(clazz == String.class) {
						pCS += 64;
					} else {
						System.out.println("Unknown Length of:" + clazz.getSimpleName());
					}
				}
				
				if(packetData.length == pCS) {
					System.out.println("Found Login Packet that likely matches");
					connectedVersion = Utils.getVersionFromPacket(packet);
				}
			}
		}
	}

	public String byteArrayToString(byte[] bytes) {
		String out = "";
		for (byte b : bytes) {
			out += b + ",";
		}
		return out;
	}

	// Accept a single client SocketChannel and proxy it to targetHost:targetPort

	private static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (byte b : bytes)
			sb.append(String.format("%02x", b & 0xff));
		return sb.toString();
	}
}