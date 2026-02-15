package io.github.SprainedSpark89.netmapp.version.java.alpha.a1016;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketHandshake extends Packet {

	public PacketHandshake(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(String.class);
		this.argsDesc.add("Username");
		this.packetID = 2;
		this.packetType = PacketType.handshake;
	}

}
