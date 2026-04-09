package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w07a;

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
		this.args.add(String.class);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("Protocol | PlayerID"); // left to server | right to client
		this.argsDesc.add("Username");
		this.argsDesc.add("Seed");
		this.argsDesc.add("World Generator");
		this.argsDesc.add("Gamemode");
		this.argsDesc.add("Dimension");
		this.argsDesc.add("Difficulty");
		this.argsDesc.add("Max Player Count");
		this.packetID = 1;
		this.packetType = PacketType.login;
	}

}
