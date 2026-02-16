package io.github.SprainedSpark89.netmapp.version.java.alpha.a123;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketRespawn extends Packet {

	public PacketRespawn(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.packetType = PacketType.respawn;
		this.packetID = 9;
	}

}
