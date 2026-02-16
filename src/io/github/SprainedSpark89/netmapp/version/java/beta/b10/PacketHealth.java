package io.github.SprainedSpark89.netmapp.version.java.beta.b10;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketHealth extends Packet {

	public PacketHealth(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Short.TYPE);
		this.argsDesc.add("Health");
		this.packetType = PacketType.health;
		this.packetID = 8;
	}

}
