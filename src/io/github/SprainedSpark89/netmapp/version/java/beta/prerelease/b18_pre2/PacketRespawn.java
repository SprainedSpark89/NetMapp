package io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre2;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketRespawn extends Packet {

	public PacketRespawn(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Long.TYPE);
		
		this.argsDesc.add("Dimension");
		this.argsDesc.add("Difficulty");
		this.argsDesc.add("Gamemode");
		this.argsDesc.add("World Height");
		this.argsDesc.add("Seed");
		
		this.packetType = PacketType.respawn;
		this.packetID = 9;
	}

}
