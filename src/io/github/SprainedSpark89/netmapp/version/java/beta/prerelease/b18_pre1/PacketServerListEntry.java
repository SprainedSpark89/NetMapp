package io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre1;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketServerListEntry extends Packet {

	public PacketServerListEntry(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.packetID = 254;
		this.packetType = PacketType.serverListEntry;
	}

}
