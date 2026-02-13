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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.ServerSimulator;
import io.github.SprainedSpark89.netmapp.version.base.Utils;
import io.github.SprainedSpark89.netmapp.version.base.VersionRegisterHook;
import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.alpha.AlphaVersion;
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
		// makeClassicNetworkThread("C0.0.15a Thread", 5565, "TCP");
		// makeClassicNetworkThread("Minecraft Java Edition Classic Thread", 25565,
		// "TCP");
		makeNetworkThread("Minecraft Java Edition Thread", 25565, "TCP");

	}

	public void makeNetworkThread(String name, int port, String connectionType) throws IOException {
		if (connectionType.contentEquals("TCP")) {
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
								ByteBuffer stream = ByteBuffer.allocate(65536);
								stream.order(ByteOrder.BIG_ENDIAN);
								SocketChannel ch = clientChannel;
								System.out.println("Handling client " + ch.getRemoteAddress());
								ByteBuffer buf = ByteBuffer.allocate(8192);
								while (ch.isOpen()) {
									int read = ch.read(buf);
									if (read > 0) {
										//dump("buf BEFORE flip", buf);
										buf.flip();
										//dump("buf AFTER flip", buf);

										//dump("stream BEFORE put", stream);
										stream.put(buf);
										//dump("stream AFTER put", stream);

										buf.clear();

										stream.flip(); // ONLY flip
										//dump("stream AFTER flip (READ MODE)", stream);

										while (true) {
											//dump("parse loop entry", stream);

											int start = stream.position();

											if (connectedVersion == null) {
												Versions v = detectAlphaLogin(stream);
												if (v == null) {
													stream.position(start);
													break;
												}
												connectedVersion = v;
											}

											if (stream.remaining() < 1)
												break;

											Packet p;
											try {
												int pos = stream.position();
												byte packetId = stream.get(pos);
												
												p = Utils.getPacketFromID(stream.get(stream.position()),
														connectedVersion);
												if(p == null) {
													log.log(Level.SEVERE,
												            "Failed to Parse Packet\n" +
												            "Position: " + pos + "\n" +
												            "Packet ID (unsigned): " + (packetId & 0xFF) + "\n" +
												            "Packet ID (signed): " + packetId + "\n" +
												            "Buffer Length: " + stream.limit()
												        );
													
													log.severe("Nearby bytes: " + dumpAround(stream, pos, 16));
													
													return;
												}
											} catch (Exception e) {
												break;
											}

											ParsedPacket parsed = tryParseAlphaPacket(p, stream);
											if (parsed == null) {
												stream.position(start);
												break;
											}

											log.info(parsed.textDescriptor);
											packetProcessor.parsePackets(parsed, clientChannel, connectedVersion, 0);
										}

										//dump("stream BEFORE compact", stream);
										stream.compact();
										//dump("stream AFTER compact", stream);
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

	public void dump(String tag, ByteBuffer b) {
		System.out.println(tag + " pos=" + b.position() + " lim=" + b.limit() + " cap=" + b.capacity());
	}

	public Versions detectAlphaLogin(ByteBuffer buf) {
		int start = buf.position();
		buf.mark();

		for (Packet packet : Utils.getLoginPackets(Utils.getTCPVersions())) {

			Versions base = Utils.getVersionFromPacket(packet);
			if (!(base instanceof AlphaVersion))
				continue;

			buf.reset();
			buf.mark();

			try {
				if (buf.remaining() < 1)
					continue;

				byte id = buf.get();
				if ((id & 0xFF) != (packet.packetID & 0xFF))
					continue;

				Integer protocol = null;

				for (Class<?> arg : packet.args) {

					if (arg == Short.TYPE) {
						if (buf.remaining() < 2)
							throw new BufferUnderflowException();
						short v = buf.getShort();
						if (protocol == null)
							protocol = (int) v;

					} else if (arg == Integer.TYPE) {
						if (buf.remaining() < 4)
							throw new BufferUnderflowException();
						int v = buf.getInt();
						if (protocol == null)
							protocol = v;

					} else if (arg == String.class) {
						if (buf.remaining() < 2)
							throw new BufferUnderflowException();
						short len = buf.getShort();
						if (buf.remaining() < len)
							throw new BufferUnderflowException();
						buf.position(buf.position() + len);

					} else {
						buf.position(start);
						throw new IllegalStateException("Unexpected alpha login arg: " + arg);
					}
				}

				if (protocol != null) {
					buf.position(start);
					return Utils.getVersionFromProtocolNumber(new AlphaVersion(Versions.instance), protocol);
				}

			} catch (BufferUnderflowException e) {
				buf.reset();
			}
		}
		buf.position(start);
		return null;
	}
	
	public static String dumpAround(ByteBuffer stream, int center, int radius) {
	    StringBuilder sb = new StringBuilder();

	    int start = Math.max(0, center - radius);
	    int end = Math.min(stream.limit(), center + radius);

	    for (int i = start; i < end; i++) {
	        sb.append(String.format("%02X ", stream.get(i)));
	    }

	    return sb.toString();
	}


	public Packet packetAlphaParse(final SocketChannel clientChannel, ServerSimulator packetProcessor, ByteBuffer buf)
			throws IOException {
		Packet packet = Utils.getPacketFromID(buf.get(buf.position()), connectedVersion);

		ParsedPacket pPacket = tryParseAlphaPacket(packet, buf);
		log.info("Connected Version is " + connectedVersion.version + "\n" + byteArrayToString(buf.array()) + "\nHex: "
				+ bytesToHex(buf.array()) + "\n" + packet.getClass().getSimpleName() + "\nData: "
				+ pPacket.textDescriptor);

		packetProcessor.parsePackets(pPacket, clientChannel, connectedVersion, 0);
		return packet;
	}

	public ParsedPacket tryParseAlphaPacket(Packet packet, ByteBuffer buf) {
		int start = buf.position();

		ParsedPacket out = new ParsedPacket();
		out.packet = packet;

		try {
			// Need at least packet id
			if (buf.remaining() < 1) {
				buf.reset();
				return null;
			}

			byte id = buf.get();
			if ((id & 0xFF) != (packet.packetID & 0xFF)) {
				buf.reset();
				return null;
			}

			StringBuilder desc = new StringBuilder();
			desc.append("PacketID: ").append(packet.packetID).append(", Data: ");

			for (Class<?> arg : packet.args) {

				if (arg == Byte.TYPE) {
					if (buf.remaining() < Byte.BYTES)
						throw new BufferUnderflowException();
					byte v = buf.get();
					out.values.add(v);
					desc.append("Byte: ").append(v).append(", ");

				} else if (arg == Short.TYPE) {
					if (buf.remaining() < Short.BYTES)
						throw new BufferUnderflowException();
					short v = buf.getShort();
					out.values.add(v);
					desc.append("Short: ").append(v).append(", ");

				} else if (arg == Integer.TYPE) {
					if (buf.remaining() < Integer.BYTES)
						throw new BufferUnderflowException();
					int v = buf.getInt();
					out.values.add(v);
					desc.append("Integer: ").append(v).append(", ");

				} else if (arg == Float.TYPE) {
					if (buf.remaining() < Float.BYTES)
						throw new BufferUnderflowException();
					float v = buf.getFloat();
					out.values.add(v);
					desc.append("Float: ").append(v).append(", ");

				} else if (arg == Long.TYPE) {
					if (buf.remaining() < Long.BYTES)
						throw new BufferUnderflowException();
					long v = buf.getLong();
					out.values.add(v);
					desc.append("Long: ").append(v).append(", ");

				} else if (arg == Double.TYPE) {
					if (buf.remaining() < Double.BYTES)
						throw new BufferUnderflowException();
					double v = buf.getDouble();
					out.values.add(v);
					desc.append("Double: ").append(v).append(", ");

				} else if (arg == String.class) {
					// Alpha strings are: short length + bytes
					if (buf.remaining() < 2)
						throw new BufferUnderflowException();
					short len = buf.getShort();
					if (buf.remaining() < len)
						throw new BufferUnderflowException();

					byte[] strBytes = new byte[len];
					buf.get(strBytes);

					String s = new String(strBytes, StandardCharsets.UTF_8);
					out.values.add(s);
					desc.append("String: \"").append(s).append("\", ");

				} else if (arg == byte[].class) {
					// Alpha arrays are usually short-length prefixed
					if (buf.remaining() < 2)
						throw new BufferUnderflowException();
					short len = buf.getShort();
					if (buf.remaining() < len)
						throw new BufferUnderflowException();

					byte[] arr = new byte[len];
					buf.get(arr);

					out.values.add(arr);
					desc.append("ByteArray[").append(len).append("], ");

				} else {
					throw new IllegalStateException("Unsupported arg type: " + arg);
				}
			}

			// trim trailing comma
			if (desc.length() >= 2) {
				desc.setLength(desc.length() - 2);
			}

			out.textDescriptor = desc.toString();
			int endPos = buf.position();

			buf.position(start);
			int startPos = buf.position();

			byte[] raw = new byte[endPos - startPos];
			buf.get(raw);

			out.rawData = raw;

			// IMPORTANT: restore position to end of packet
			buf.position(endPos);

			return out;


		} catch (BufferUnderflowException e) {
			// Not enough data yet — rewind
			buf.position(start);
			return null;
		}
	}

	/*
	 * public boolean tryParseAlpha( ByteBuffer stream, SocketChannel ch,
	 * ServerSimulator processor ) throws IOException {
	 * 
	 * stream.mark();
	 * 
	 * if (stream.remaining() < 1) { stream.reset(); return false; }
	 * 
	 * byte packetId = stream.get();
	 * 
	 * if (packetId != 0x00) { log.warning("Unknown Alpha packet id: " + packetId);
	 * return true; // skip }
	 * 
	 * // username length if (stream.remaining() < 2) { stream.reset(); return
	 * false; }
	 * 
	 * short userLen = stream.getShort();
	 * 
	 * if (stream.remaining() < userLen) { stream.reset(); return false; }
	 * 
	 * byte[] userBytes = new byte[userLen]; stream.get(userBytes); String username
	 * = new String(userBytes, StandardCharsets.UTF_8);
	 * 
	 * // password length if (stream.remaining() < 2) { stream.reset(); return
	 * false; }
	 * 
	 * short passLen = stream.getShort();
	 * 
	 * if (stream.remaining() < passLen) { stream.reset(); return false; }
	 * 
	 * byte[] passBytes = new byte[passLen]; stream.get(passBytes); String password
	 * = new String(passBytes, StandardCharsets.UTF_8);
	 * 
	 * log.info("Alpha Login: " + username + " / " + password);
	 * 
	 * return true; // consumed one full packet }
	 */

	public void makeClassicNetworkThread(String name, int port, String connectionType) throws IOException {
		if (connectionType.contentEquals("TCP")) {
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
										getConnectedClassicTCPVersion(data);

										if (connectedVersion == null && data.length == 1) {
											connectedVersion = new AlphaVersion(Versions.instance);
										}

										int offset = 0;

										// Keep looping until we’ve consumed the whole buffer
										if (!(connectedVersion instanceof AlphaVersion)) {
											while (offset < data.length) {
												// Parse packet at current offset
												Packet packet = packetClassicParse(clientChannel, packetProcessor, data,
														offset);

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
												// packetProcessor.process(packet, Arrays.copyOfRange(data, offset,
												// offset + packetLength));

												// Move offset forward
												offset += packetLength;

												// Optional: skip login packets if you want special handling
												if (packet.packetType == PacketType.login) {
													break; // or handle differently
												}
											}
										} else {
											log.info("Connected Version is an unknown alpha version\n"
													+ byteArrayToString(data) + "\nHex: " + bytesToHex(data) + "\n"
													+ "Unknown Packet" + "\nData: " + "No Descriptor");
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
						}, "NetMapp-Classic-Client-" + name).start();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}, name));
			System.out.println("Done!\nStarting Thread...");
			networkingThreads.get(currentThreadID).start();
		}
	}

	public Packet packetClassicParse(final SocketChannel clientChannel, ServerSimulator packetProcessor, byte[] data,
			int offset) throws IOException {
		Packet packet = Utils.getPacketFromID(data[offset], connectedVersion);
		ParsedPacket pPacket = parseClassicPacket(packet, data, offset);
		log.info("Connected Version is " + connectedVersion.version + "\n" + byteArrayToString(data) + "\nHex: "
				+ bytesToHex(data) + "\n" + packet.getClass().getSimpleName() + "\nData: " + pPacket.textDescriptor);

		packetProcessor.parsePackets(pPacket, clientChannel, connectedVersion, offset);
		return packet;
	}

	public ParsedPacket parseClassicPacket(Packet packet, byte[] data, int offset) {
		ParsedPacket processPacket = new ParsedPacket();
		processPacket.packet = packet;
		processPacket.rawData = data;
		// basic sanity check
		if (data == null || data.length < 1)
			return null;

		// packet ID mismatch
		if ((data[offset] & 0xFF) != (packet.packetID & 0xFF))
			return null;

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
					out.append("ByteArray[1024]: ").append("[" + byteArrayToString(arr) + "]").append(", ");
					processPacket.values.add(arr);

				} else if (clazz == String.class) {
					byte[] strBytes = new byte[64];
					buf.get(strBytes);

					String str = new String(strBytes, StandardCharsets.UTF_8).replaceAll("\0", "").trim();

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

	public void getConnectedClassicTCPVersion(byte[] packetData) {
		List<Packet> loginPackets = Utils.getLoginPackets(Utils.getTCPVersions());
		for (Packet packet : loginPackets) {
			if (packetData[0] == packet.packetID) { // byte checksum checking to try to find a match
				// classic strings are always 64 bytes, just with padding
				int pCS = 0; // first classic check
				pCS++; // packet id is 1 byte
				for (Class<?> clazz : packet.args) {
					if (clazz == Long.TYPE) {
						pCS += Long.BYTES;
					} else if (clazz == Short.TYPE) {
						pCS += Short.BYTES;
					} else if (clazz == Byte.TYPE) {
						pCS += Byte.BYTES;
					} else if (clazz == Double.TYPE) {
						pCS += Double.BYTES;
					} else if (clazz == Float.TYPE) {
						pCS += Float.BYTES;
					} else if (clazz == byte[].class) {
						pCS += 1024;
					} else if (clazz == String.class) {
						pCS += 64;
					} else if (clazz == Integer.TYPE) {
						pCS += Integer.BYTES;
					} else {
						System.out.println("Unknown Length of:" + clazz.getSimpleName());
					}
				}

				if (packetData.length == pCS) {
					System.out.println("Found Login Packet that likely matches");
					connectedVersion = Utils.getVersionFromPacket(packet);
					if (!(connectedVersion instanceof c0_0_15a)) {
						ParsedPacket pPacket = parseClassicPacket(packet, packetData, 0);
						if (connectedVersion instanceof ClassicVersion) {
							int protocol = (int) (byte) pPacket.values.get(0);
							connectedVersion = Utils.getVersionFromProtocolNumber(new ClassicVersion(Versions.instance),
									protocol);
						} else if (connectedVersion instanceof AlphaVersion) {
							int protocol = (int) pPacket.values.get(0);
							connectedVersion = Utils.getVersionFromProtocolNumber(new AlphaVersion(Versions.instance),
									protocol);
						}
					}
				}
			}
		}
	}

	public static String byteArrayToString(byte[] bytes) {
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