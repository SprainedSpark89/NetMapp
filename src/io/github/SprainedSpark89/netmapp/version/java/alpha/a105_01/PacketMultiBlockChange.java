package io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketMultiBlockChange extends Packet {

	public PacketMultiBlockChange(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(short[].class); // written as multiple shorts
		this.args.add(byte[].class);
		this.args.add(byte[].class);
		this.argsDesc.add("X");
		this.argsDesc.add("Z");
		this.argsDesc.add("Coord Array Size");
		this.argsDesc.add("Coord Array");
		this.argsDesc.add("Type Array");
		this.argsDesc.add("Metadata Array");
		this.packetID = 11;
		this.packetType = PacketType.multiBlockUpdate;
	}

}
