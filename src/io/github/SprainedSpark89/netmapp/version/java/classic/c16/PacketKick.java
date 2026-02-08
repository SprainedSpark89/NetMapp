package io.github.SprainedSpark89.netmapp.version.java.classic.c16;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketKick extends Packet {

	public PacketKick(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(String.class);
		this.argsDesc.add("Kick Message");
		this.packetID = 14;
		this.packetType = PacketType.kick;
	}

}
