package io.github.SprainedSpark89.netmapp.version.java.beta.b15;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketLogin extends Packet {

	public PacketLogin(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(String.class);
		this.args.add(Long.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("Protocol");
		this.argsDesc.add("Username");
		this.argsDesc.add("Seed");
		this.argsDesc.add("Dimension");
		this.packetID = 1;
		this.packetType = PacketType.login;
	}

}
