package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w27a;

import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketChunks extends Packet {

	public PacketChunks(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		
		this.args.add(Short.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(byte[].class);
		this.args.add(int[].class);
		this.args.add(int[].class);
		this.args.add(short[].class);
		this.args.add(short[].class);
		
		this.argsDesc.add("Chunks X Length");
		this.argsDesc.add("Size");
		this.argsDesc.add("Compressed Data");
		this.argsDesc.add("X Chunks");
		this.argsDesc.add("Z Chunks");
		this.argsDesc.add("Lower Ids");
		this.argsDesc.add("Higher Ids");
		
		this.packetID = 56;
		this.packetType = PacketType.chunks;
		
		this.read = new SpecialRead(true, 3);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		short chunkXLength = (short) out.values.get(0);
		int[] chunkX = new int[chunkXLength];
		int[] chunkZ = new int[chunkXLength];
		short[] lowerIDs = new short[chunkXLength];
		short[] higherIDs = new short[chunkXLength];
		
		for(int i = 0; i < chunkXLength; i++) {
			chunkX[i] = (int)NetMapp.parseArgs(out.packet, buf, Integer.TYPE, (short) 0);
			chunkZ[i] = (int)NetMapp.parseArgs(out.packet, buf, Integer.TYPE, (short) 0);
			lowerIDs[i] = (byte)NetMapp.parseArgs(out.packet, buf, Byte.TYPE, (short) 0);
			higherIDs[i] = (byte)NetMapp.parseArgs(out.packet, buf, Byte.TYPE, (short) 0);
		}
		
		out.values.add(chunkX);
	    desc.append("IntegerArray[").append(chunkXLength).append("], ");
	    
	    out.values.add(chunkZ);
	    desc.append("IntegerArray[").append(chunkXLength).append("], ");
	    
	    out.values.add(lowerIDs);
	    desc.append("ShortArray[").append(chunkXLength).append("], ");
	    
	    out.values.add(higherIDs);
	    desc.append("ShortArray[").append(chunkXLength).append("], ");
	}

}
