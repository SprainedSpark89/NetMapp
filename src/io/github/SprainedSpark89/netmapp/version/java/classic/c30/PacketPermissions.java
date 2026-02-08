package io.github.SprainedSpark89.netmapp.version.java.classic.c30;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;

public class PacketPermissions extends Packet {

	public PacketPermissions(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE); // if it's >= 100, you can break bedrock
		this.argsDesc.add("UserType");
		this.packetID = 15;
	}

}
