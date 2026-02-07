package io.github.SprainedSpark89.netmapp.version.java.classic.c15;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketLevelInit extends Packet {

	public PacketLevelInit(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.packetType = PacketType.startWorldData;
		this.packetID = 1;
	}

}
