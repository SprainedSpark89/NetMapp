package io.github.SprainedSpark89.netmapp.version.java.alpha.a105;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketHandshake extends Packet {

	public PacketHandshake(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(String.class);
		this.args.add(String.class);
		this.argsDesc.add("Protocol");
		this.argsDesc.add("Username");
		this.argsDesc.add("Password");
		this.packetID = 0;
		this.packetType = PacketType.login;
	}

}
