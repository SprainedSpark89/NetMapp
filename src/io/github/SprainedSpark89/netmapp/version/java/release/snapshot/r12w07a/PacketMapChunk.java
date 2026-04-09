package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w07a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketMapChunk extends Packet {

	public PacketMapChunk(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Boolean.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(byte[].class);
		this.argsDesc.add("X");
		this.argsDesc.add("Z");
		this.argsDesc.add("Full Chunk");
		this.argsDesc.add("Low Ids");
		this.argsDesc.add("High Ids");
		this.argsDesc.add("Compressed Size");
		this.argsDesc.add("Chunk Data");
		this.packetID = 51;
		this.packetType = PacketType.worldData;
	}

}
