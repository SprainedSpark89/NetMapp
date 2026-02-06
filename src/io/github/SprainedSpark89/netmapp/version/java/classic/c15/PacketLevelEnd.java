package io.github.SprainedSpark89.netmapp.version.java.classic.c15;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketLevelEnd extends Packet {

	public PacketLevelEnd(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.argsDesc.add("Level Width");
		this.argsDesc.add("Level Height");
		this.argsDesc.add("Level Depth");
		this.packetType = PacketType.worldDataEnd;
	}

}
