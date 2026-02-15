package io.github.SprainedSpark89.netmapp.version.java.alpha.a1017;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketTime extends Packet {

	public PacketTime(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Long.TYPE);
		this.argsDesc.add("Time");
		this.packetID = 4;
		this.packetType = PacketType.time;
	}

}
