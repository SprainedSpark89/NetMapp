/**
 * 
 */
package io.github.SprainedSpark89.netmapp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.ServerSimulator;
import io.github.SprainedSpark89.netmapp.version.base.Utils;
import io.github.SprainedSpark89.netmapp.version.base.VersionRegisterHook;
import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.classic.ClassicVersion;
import io.github.SprainedSpark89.netmapp.version.java.classic.c15.c0_0_15a;

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
		makeNetworkThread("Minecraft Java Edition Thread", 25565, "TCP");

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
							ServerSimulator packetProcessor = new ServerSimulator();
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
										
										
										int offset = 0;

										// Keep looping until we’ve consumed the whole buffer
										while (offset < data.length) {
										    // Parse packet at current offset
										    Packet packet = packetParse(clientChannel, packetProcessor, data, offset);

										    if (packet == null) {
										        // Couldn’t parse a valid packet here — maybe incomplete data
										        break;
										    }

										    // Get the length of this packet
										    int packetLength = Utils.getPacketLength(packet, connectedVersion);

										    // Make sure there’s enough data remaining
										    if (offset + packetLength > data.length) {
										        // Incomplete packet — wait for more data
										        break;
										    }

										    // Process the packet
										    //packetProcessor.process(packet, Arrays.copyOfRange(data, offset, offset + packetLength));

										    // Move offset forward
										    offset += packetLength;

										    // Optional: skip login packets if you want special handling
										    if (packet.packetType == PacketType.login) {
										        break; // or handle differently
										    }
										}

										
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

	public Packet packetParse(final SocketChannel clientChannel, ServerSimulator packetProcessor, byte[] data, int offset)
			throws IOException {
		Packet packet = Utils.getPacketFromID(data[offset], connectedVersion);
		ParsedPacket pPacket = parsePacket(packet, data, offset);
		log.info("Connected Version is " + connectedVersion.version + "\n" +
		byteArrayToString(data) + "\nHex: " + bytesToHex(data) + "\n"
				+ packet.getClass().getSimpleName() + "\nData: "
				+ pPacket.textDescriptor);
		
		packetProcessor.parsePackets(pPacket, clientChannel, connectedVersion, offset);
		return packet;
	}
	
	public ParsedPacket parsePacket(Packet packet, byte[] data, int offset) {
		ParsedPacket processPacket = new ParsedPacket();
		processPacket.packet = packet;
		processPacket.rawData = data;
	    // basic sanity check
	    if (data == null || data.length < 1) return null;

	    // packet ID mismatch
	    if ((data[offset] & 0xFF) != (packet.packetID & 0xFF)) return null;

	    StringBuilder out = new StringBuilder();
	    out.append("PacketID: ").append(packet.packetID).append(", Data: ");

	    ByteBuffer buf = ByteBuffer.wrap(data).order(ByteOrder.BIG_ENDIAN);

	    try {
	        buf.position(1 + (offset)); // skip packet id

	        for (Class<?> clazz : packet.args) {

	            if (clazz == Long.TYPE) {
	                long v = buf.getLong();
	                out.append("Long: ").append(v).append(", ");
	                processPacket.values.add(v);

	            } else if (clazz == Integer.TYPE) {
	                int v = buf.getInt();
	                out.append("Int: ").append(v).append(", ");
	                processPacket.values.add(v);

	            } else if (clazz == Short.TYPE) {
	                short v = buf.getShort();
	                out.append("Short: ").append(v).append(", ");
	                processPacket.values.add(v);

	            } else if (clazz == Byte.TYPE) {
	                byte v = buf.get();
	                out.append("Byte: ").append(v).append(", ");
	                processPacket.values.add(v);

	            } else if (clazz == Float.TYPE) {
	                float v = buf.getFloat();
	                out.append("Float: ").append(v).append(", ");
	                processPacket.values.add(v);

	            } else if (clazz == Double.TYPE) {
	                double v = buf.getDouble();
	                out.append("Double: ").append(v).append(", ");
	                processPacket.values.add(v);

	            } else if (clazz == byte[].class) {
	                byte[] arr = new byte[1024];
	                buf.get(arr);
	                out.append("ByteArray[1024]: ")
	                   .append("[" + byteArrayToString(arr) + "]")
	                   .append(", ");
	                processPacket.values.add(arr);

	            } else if (clazz == String.class) {
	                byte[] strBytes = new byte[64];
	                buf.get(strBytes);

	                String str = new String(strBytes, StandardCharsets.UTF_8)
	                        .replaceAll("\0", "")
	                        .trim();

	                out.append("String: \"").append(str).append("\", ");
	                processPacket.values.add(str);
	            } else {
	                out.append("UnknownType, ");
	            }
	        }

	    } catch (BufferUnderflowException e) {
	        // packet doesn't match this schema
	        return null;
	    }

	    // remove trailing ", "
	    if (out.length() >= 2) {
	        out.setLength(out.length() - 2);
	    }
	    processPacket.textDescriptor = out.toString();
	    return processPacket;
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
					if(!(connectedVersion instanceof c0_0_15a)) {
						ParsedPacket pPacket = parsePacket(packet, packetData, 0);
						if(connectedVersion instanceof ClassicVersion) {
							int protocol = (int)pPacket.values.get(0);
							connectedVersion = Utils.getVersionFromProtocolNumber(new ClassicVersion(Versions.instance), protocol);
						}
					}
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