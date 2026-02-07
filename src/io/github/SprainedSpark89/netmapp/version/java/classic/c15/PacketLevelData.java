package io.github.SprainedSpark89.netmapp.version.java.classic.c15;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketLevelData extends Packet {

	public PacketLevelData(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Short.TYPE);
		this.args.add(byte[].class);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("Block array size (len the number of bytes to write.)");
		this.argsDesc.add("Block Array (the world)");
		this.argsDesc.add("Progress bar");
		this.packetType = PacketType.worldData;
		this.packetID = 3;
	}
	
}
