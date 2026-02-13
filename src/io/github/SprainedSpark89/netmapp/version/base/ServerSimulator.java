package io.github.SprainedSpark89.netmapp.version.base;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.java.alpha.AlphaVersion;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105.a1_0_5;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01.a1_0_5_01;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.a1_0_6;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a107.a1_0_7;
import io.github.SprainedSpark89.netmapp.version.java.classic.ClassicVersion;

public class ServerSimulator { // basic server simulator which wont really be used at all except for testing
	
	public Thread keepAliveThread;
	
	public static long lastPacketTimeInNano;

	public void parsePackets(ParsedPacket pPacket, SocketChannel client, Versions ver, int offset) throws IOException {
		if(ver instanceof ClassicVersion) {
			if(pPacket.packet.packetType == PacketType.login) {
				// resend client login to put client into proper mode
				ByteBuffer buf = ByteBuffer.wrap(pPacket.rawData).order(ByteOrder.BIG_ENDIAN);
				client.write(buf);
				// send world data start
				buf = ByteBuffer.wrap(new byte[] {(byte) Utils.invertMap(ver.packetList).get(PacketType.startWorldData).packetID}).order(ByteOrder.BIG_ENDIAN);
				client.write(buf);

				buf = ByteBuffer.allocate(1 + 2 + 1024 + 1);
				buf.order(ByteOrder.BIG_ENDIAN);
				byte[] chunk = new byte[1024];
				byte[] level = new byte[4096];
				Arrays.fill(level, 0, 2048, (byte) 1);
				Arrays.fill(level, 2048, 4096, (byte) 0);
				byte[] levelData = buildCompressedLevel(level);

				int length = levelData.length; // size 16x16x16, then compressed
				int sizeOverflow;
				for (int i = 0; length > 0; length -= sizeOverflow, i += sizeOverflow) {
					sizeOverflow = ((length > chunk.length) ? chunk.length : length);
					chunk = new byte[1024];
					System.arraycopy(levelData, i, chunk, 0, sizeOverflow);
					//buf = ByteBuffer.wrap(new byte[] {(byte) Utils.invertMap(ver.packetList).get(PacketType.worldData).packetID}).order(ByteOrder.BIG_ENDIAN);
					buf = ByteBuffer.allocate(1 + 2 + 1024 + 1);
					buf.order(ByteOrder.BIG_ENDIAN);

					buf.put((byte) Utils.invertMap(ver.packetList).get(PacketType.worldData).packetID);
					buf.putShort((short) sizeOverflow);
					buf.put(chunk);
					buf.put((byte) ((i + sizeOverflow) * 100 / 4096));
					buf.flip();
					client.write(buf);
					buf.clear();
				}
				buf.clear();
				buf = ByteBuffer.allocate(7).order(ByteOrder.BIG_ENDIAN);	
				buf.put((byte) Utils.invertMap(ver.packetList).get(PacketType.worldDataEnd).packetID);
				buf.putShort((short) 16);
				buf.putShort((short) 16);
				buf.putShort((short) 16);
				buf.flip();
				client.write(buf);
			} else if(pPacket.packet.packetType == PacketType.blockUpdate) {
				ByteBuffer buf = ByteBuffer.allocate(Utils.getPacketLength(pPacket.packet, ver)).order(ByteOrder.BIG_ENDIAN);
				buf.put((byte)Utils.invertMap(ver.packetList).get(PacketType.setBlock).packetID);
				buf.putShort((short) pPacket.values.get(0));
				buf.putShort((short) pPacket.values.get(1));
				buf.putShort((short) pPacket.values.get(2));
				buf.put((byte)((byte)pPacket.values.get(3) * (byte)pPacket.values.get(4)));
				buf.flip();
				client.write(buf);
			} else if(pPacket.packet.packetType == PacketType.chat) {
				client.write(ByteBuffer.wrap(pPacket.rawData).order(ByteOrder.BIG_ENDIAN));
			}
		} else if(ver instanceof AlphaVersion) {
			if(pPacket.packet.packetType == PacketType.login) {
				// 1. Login Response
				int packetSize = 1 + 4 + 2 + 0 + 2 + 0;
				
				ByteBuffer buf = ByteBuffer.allocate(packetSize).order(ByteOrder.BIG_ENDIAN);
				buf.put((byte)Utils.invertMap(ver.packetList).get(PacketType.login).packetID); // Login packet ID (Packet0Login)
				buf.putInt(0);     // Protocol version
				buf.putShort((short) 0); // Username length
				// (no username bytes)
				buf.putShort((short) 0); // Password length
				// (no password bytes)
				writeFully(client, buf);
				
				// Chunk, -176 to 176, both axis
				
				byte[] chunk = new byte[16 * 128 * 16];
				//Arrays.fill(chunk, 0, ((16 * 128 * 16)/2)-1, (byte) 0); // Air
				//Arrays.fill(chunk, ((16 * 128 * 16)/2)-1, 16 * 128 * 16, (byte) 1); // Stone
				for (int x = 0; x < 16; x++) {
				    for (int z = 0; z < 16; z++) {
				        for (int y = 0; y < 128; y++) {
				            int index = (x << 11) | (z << 7) | y; // x*2048 + z*128 + y
				            if (y < 64) {
				                chunk[index] = 17; // some block ID (stone)
				            } else {
				                chunk[index] = 0; // air
				            }
				        }
				    }
				}
				Deflater deflater = new Deflater();
				deflater.setInput(chunk);
				deflater.finish();
				byte[] compressed = new byte[chunk.length * 2];
				int compressedLen = deflater.deflate(compressed);
				deflater.end();
				
				packetSize = 1 + 4 + 2 + 4 + 1 + 1 + 1 + 4 + compressedLen;
				for (int x = -64; x <= 64; x += 16) {
					for (int z = -64; z <= 64; z += 16) {
						writeAlphaChunk(client, ver, packetSize, compressed, compressedLen, x, (short) 0, z);
					}
				}
				
				
				// 2. Player Position / Rotation
				packetSize = 1 + 8 + 8 + 8 + 4 + 4;
				if(!(ver instanceof a1_0_5)) {
					packetSize++;
				}
				
				if(ver instanceof a1_0_7) {
					packetSize = Byte.BYTES + Byte.BYTES;
				}
				
				buf = ByteBuffer.allocate(packetSize).order(ByteOrder.BIG_ENDIAN);
				if(!(ver instanceof a1_0_5 || ver instanceof a1_0_5_01 || ver instanceof a1_0_6)) {
					buf.put((byte)Utils.invertMap(ver.packetList).get(PacketType.flying).packetID);  // Entity flying packet ID
					buf.put((byte) 0);
				} else {
					buf.put((byte)Utils.invertMap(ver.packetList).get(PacketType.entityMoveRot).packetID);  // Entity position packet ID
				
					buf.putDouble(0);   // X
					buf.putDouble(67);  // Y
					buf.putDouble(0);   // Z
					buf.putFloat(0);    // Yaw
					buf.putFloat(0);    // Pitch
					if(!(ver instanceof a1_0_5)) {
						buf.put((byte) 0);
					}
				}
				writeFully(client, buf);
				
				if(!(ver instanceof a1_0_5 || ver instanceof a1_0_5_01)) {
					this.createKeepAliveThread(client, ver, 30);
				}
			} else if(pPacket.packet.packetType == PacketType.entityMoveRot) {
				
				// failed fix, client couldn't make it out of the chunk:
				
				/*if(!(ver instanceof a1_0_5 || ver instanceof a1_0_5_01)) {
					int playerX = (int)(double)pPacket.values.get(0);
					int playerZ = (int)(double)pPacket.values.get(2);
					
					int loadChunkPacketSize = Byte.BYTES+
							Integer.BYTES+
							Integer.BYTES+
							Byte.BYTES;
					byte[] chunkStone = new byte[16 * 128 * 16];
					byte[] chunkAir = new byte[16 * 128 * 16];
					//Arrays.fill(chunk, 0, ((16 * 128 * 16)/2)-1, (byte) 0); // Air
					//Arrays.fill(chunk, ((16 * 128 * 16)/2)-1, 16 * 128 * 16, (byte) 1); // Stone
					for (int x = 0; x < 16; x++) {
					    for (int z = 0; z < 16; z++) {
					        for (int y = 0; y < 128; y++) {
					            int index = (x << 11) | (z << 7) | y; // x*2048 + z*128 + y
					            if (y < 64) {
					                chunkStone[index] = 1; // some block ID (stone)
					            } else {
					                chunkStone[index] = 0; // air
					            }
					        }
					    }
					}
					
					Deflater deflater1 = new Deflater();
					deflater1.setInput(chunkStone);
					deflater1.finish();
					byte[] compressedStone = new byte[chunkStone.length * 2];
					int compressedLen1 = deflater1.deflate(compressedStone);
					deflater1.end();
					
					Deflater deflater2 = new Deflater();
					deflater2.setInput(chunkAir);
					deflater2.finish();
					byte[] compressedAir = new byte[chunkStone.length * 2];
					int compressedLen2 = deflater2.deflate(compressedAir);
					deflater2.end();
					
					int playerChunkX = playerX >> 4;
					int playerChunkZ = playerZ >> 4;
					
					int packetSizeStone = 1 + 4 + 2 + 4 + 1 + 1 + 1 + 4 + compressedLen1;
					int packetSizeAir = 1 + 4 + 2 + 4 + 1 + 1 + 1 + 4 + compressedLen2;
					if(prevCX != playerChunkX || prevCZ != playerChunkZ) {
					for (int x = -176; x <= 176; x += 16) {
						for (int z = -176; z <= 176; z += 16) {
							if(playerChunkX + x < -176 || playerChunkX + x > 176 || playerChunkZ + z < -176|| playerChunkZ + z > 176) {
								writeAlphaChunk(client, ver, packetSizeAir, compressedAir, compressedLen2, x + playerChunkX, (short) 0, z + playerChunkZ);
							} else {
								writeAlphaChunk(client, ver, packetSizeStone, compressedStone, compressedLen1, x + playerChunkX, (short) 0, z + playerChunkZ);
							}
						}
					}
					}
					/*for (int x = -1; x <= 1; x += 1) {
						for (int z = -1; z <= 1; z += 1) {
							
							
							ByteBuffer buf = ByteBuffer.allocate(loadChunkPacketSize).order(ByteOrder.BIG_ENDIAN);
							buf.put((byte)Utils.invertMap(ver.packetList).get(PacketType.chunkLoad).packetID);
							buf.putInt((x + (playerX >> 4)));         // chunk X
							buf.putInt((z + (playerZ >> 4)));         // chunk Z
							buf.put((byte) 1);    // load
							writeFully(client, buf);
						}
					}*/
					//prevCX = playerChunkX;prevCZ = playerChunkZ;
				//}
			} else if(pPacket.packet.packetType == PacketType.blockPlace) {
				int blockID;
				if(ver instanceof a1_0_7 || ver instanceof a1_0_6) {
					blockID = (byte) pPacket.values.get(0);
				} else {
					blockID = (short) pPacket.values.get(0);
				}
				if(heldID < 256 && heldID >= 0) {
				int x = (int) pPacket.values.get(1);
				byte y = (byte) pPacket.values.get(2);
				int z = (int) pPacket.values.get(3);
				byte face = (byte) pPacket.values.get(4);
				
				if(face == 0) {
					y--;
				} else if(face == 1) {
					y++;
				} else if(face == 2) {
					z--;
				} else if(face == 3) {
					z++;
				} else if(face == 4) {
					x--;
				} else if(face == 5) {
					x++;
				}
				
				int packetSize = Byte.BYTES +
						Integer.BYTES +
						Byte.BYTES +
						Integer.BYTES +
						Byte.BYTES +
						Byte.BYTES;
				
				if(!(ver instanceof a1_0_7 || ver instanceof a1_0_6)) {
					packetSize -= Byte.BYTES;
					packetSize += Short.BYTES;
				}
				
				ByteBuffer buf = ByteBuffer.allocate(packetSize).order(ByteOrder.BIG_ENDIAN);
				buf.put((byte)Utils.invertMap(ver.packetList).get(PacketType.blockUpdate).packetID); // id
				buf.putInt(x);
				buf.put(y);
				buf.putInt(z);
				
				if(ver instanceof a1_0_7 || ver instanceof a1_0_6) {
					buf.put((byte) blockID);
				} else {
					buf.putShort((short) blockID);
				}
				
				buf.put((byte) 0);
				writeFully(client, buf);
				}
			} else if(pPacket.packet.packetType == PacketType.dig) {
				byte status = (byte) pPacket.values.get(0);
				if(status == 3) {
					int x = (int) pPacket.values.get(1);
					byte y = (byte) pPacket.values.get(2);
					int z = (int) pPacket.values.get(3);
				
					int packetSize = Byte.BYTES +
						Integer.BYTES +
						Byte.BYTES +
						Integer.BYTES +
						Byte.BYTES +
						Byte.BYTES;
					ByteBuffer buf = ByteBuffer.allocate(packetSize).order(ByteOrder.BIG_ENDIAN);
					buf.put((byte)Utils.invertMap(ver.packetList).get(PacketType.blockUpdate).packetID); // id
					buf.putInt(x);
					buf.put(y);
					buf.putInt(z);
					buf.put((byte) 0);
					buf.put((byte) 0);
					writeFully(client, buf);
					/*if(!(ver instanceof a1_0_7 || ver instanceof a1_0_6)) {
						packetSize = Byte.BYTES +
								Integer.BYTES +
								Short.BYTES +
								Byte.BYTES +
								Integer.BYTES +
								Integer.BYTES +
								Integer.BYTES +
								Byte.BYTES +
								Byte.BYTES +
								Byte.BYTES;
						buf = ByteBuffer.allocate(packetSize).order(ByteOrder.BIG_ENDIAN);
						
					}*/
				}
			} else if(pPacket.packet.packetType == PacketType.handSwap) {
				heldID = (short) pPacket.values.get(1);
			}
		}
	}
	
	public short heldID = 0;
	
	//int prevCX = 0;
	//int prevCZ = 0;
	
	public void createKeepAliveThread(SocketChannel client, Versions ver, long timingInSecconds){
		this.keepAliveThread = new Thread(()->{
			ByteBuffer buf = ByteBuffer.allocate(Byte.BYTES).order(ByteOrder.BIG_ENDIAN);
			buf.put((byte)Utils.invertMap(ver.packetList).get(PacketType.keepAlive).packetID);
			while(true) {
				if(!client.isConnected()) {
					break;
				}

				
				
				if(Duration.ofNanos(System.nanoTime() - lastPacketTimeInNano).getSeconds() >= timingInSecconds) {
					
					ByteBuffer bufCopy = buf.asReadOnlyBuffer();
					try {
						writeFully(client, bufCopy);
						System.out.println("Sending Keep Alive...");
					} catch (IOException e) {
						// TODO Auto-generated catch block
					}
					
				/*try {
					Thread.sleep(Duration.ofSeconds(timingInSecconds).toMillis());
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				}*/
				}
			}
		});
		this.keepAliveThread.start();
	}

	public void writeAlphaChunk(SocketChannel client, Versions ver, int packetSize, byte[] compressed,
			int compressedLen, int x, short y, int z) throws IOException {
		if(!(ver instanceof a1_0_5 || ver instanceof a1_0_5_01)) {
			int loadChunkPacketSize = Byte.BYTES+
					Integer.BYTES+
					Integer.BYTES+
					Byte.BYTES;
			
			ByteBuffer buf = ByteBuffer.allocate(loadChunkPacketSize).order(ByteOrder.BIG_ENDIAN);
			buf.put((byte)Utils.invertMap(ver.packetList).get(PacketType.chunkLoad).packetID);
			buf.putInt(x/16);         // chunk X
			buf.putInt(z/16);         // chunk Z
			buf.put((byte) 1);    // load
			writeFully(client, buf);
		}
		
		ByteBuffer buf;
		buf = ByteBuffer.allocate(packetSize).order(ByteOrder.BIG_ENDIAN);
		buf.put((byte)Utils.invertMap(ver.packetList).get(PacketType.worldData).packetID);
		buf.putInt(x);         // chunk X
		buf.putShort((short) y); // chunk Y
		buf.putInt(z);         // chunk Z
		buf.put((byte) 15);    // xSize - 1
		buf.put((byte) 127);   // ySize - 1
		buf.put((byte) 15);    // zSize - 1
		buf.putInt(compressedLen);
		buf.put(compressed, 0, compressedLen);
		writeFully(client, buf);
		
		
	}
	
	public static void writeFully(SocketChannel ch, ByteBuffer buf) throws IOException {
	    buf.flip();
	    while (buf.hasRemaining()) {
	        ch.write(buf);
	    }
	    lastPacketTimeInNano = System.nanoTime();
	}


	public byte[] buildCompressedLevel(byte[] rawBlocks) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(baos);
		DataOutputStream dos = new DataOutputStream(gzip);

		// This int is REQUIRED
		dos.writeInt(rawBlocks.length);

		// Then the raw block bytes
		dos.write(rawBlocks);

		dos.close(); // closes gzip too
		return baos.toByteArray();
	}


	// old
	/*public byte[] level() {
		List<Byte> lazyByteArray = new ArrayList<Byte>();
		int i = 0; // i don't feel like using a for loop
		// 4096
		// 2048
		while(i <= 2048) {
			lazyByteArray.add((byte)0);
			i++;
		}
		i = 0;
		while(i <= 2048) {
			lazyByteArray.add((byte)1);
			i++;
		}
		return toPrimitivesWithStreams(lazyByteArray.toArray(new Byte[0]));
	}



	public static byte[] toPrimitivesWithStreams(Byte[] oBytes) {
	    // There is no mapToByte, so we map to IntStream and then convert manually
	    byte[] bytes = new byte[oBytes.length];
	    int i = 0;
	    for (Byte b : oBytes) {
	        bytes[i++] = b;
	    }
	    return bytes;
	}*/


}
