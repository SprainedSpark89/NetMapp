package io.github.SprainedSpark89.netmapp.version.java.classic.c20;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketLogin extends Packet {

	public PacketLogin(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		
		this.args.add(Byte.TYPE);
		this.args.add(String.class);
		this.args.add(String.class);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("Protocol Number");
		this.argsDesc.add("Username");
		this.argsDesc.add("Likely MPPASS");
		this.argsDesc.add("Unused?");
		this.packetType = PacketType.login;
		this.packetID = 0;
	}

}
