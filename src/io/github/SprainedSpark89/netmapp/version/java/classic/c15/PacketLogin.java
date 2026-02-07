package io.github.SprainedSpark89.netmapp.version.java.classic.c15;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketLogin extends Packet {

	public PacketLogin(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(String.class);
		this.argsDesc.add("Username");
		this.packetType = PacketType.login;
		this.packetID = 0;
	}

}
