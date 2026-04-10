package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w18a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketHandshake extends Packet {

	public PacketHandshake(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(String.class);
		this.args.add(String.class);
		this.args.add(Integer.TYPE);
		this.argsDesc.add("Version");
		this.argsDesc.add("Username");
		this.argsDesc.add("Address");
		this.argsDesc.add("Port");
		this.packetID = 2;
		this.packetType = PacketType.handshake;
	}

}
