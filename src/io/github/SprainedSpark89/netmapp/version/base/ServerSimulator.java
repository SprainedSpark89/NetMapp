package io.github.SprainedSpark89.netmapp.version.base;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

public class ServerSimulator { // basic server simulator which wont really be used at all except for testing
	
	public void parsePackets(ParsedPacket pPacket, SocketChannel client, Versions ver, int offset) throws IOException {
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
		}
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
