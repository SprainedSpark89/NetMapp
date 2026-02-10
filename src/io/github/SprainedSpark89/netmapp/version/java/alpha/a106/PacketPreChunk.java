package io.github.SprainedSpark89.netmapp.version.java.alpha.a106;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketPreChunk extends Packet {

	public PacketPreChunk(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE); // 1 is load chunk, 0 is unload
		this.argsDesc.add("X");
		this.argsDesc.add("Z");
		this.argsDesc.add("Load Chunk");
		this.packetID = 9;
		this.packetType = PacketType.chunkLoad;	
	}

}
