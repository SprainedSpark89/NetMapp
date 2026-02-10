package io.github.SprainedSpark89.netmapp.version.java.alpha.a106;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketEntity extends Packet { // Just like the real system

	public PacketEntity(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.argsDesc.add("EntityID");
		this.packetType = PacketType.entity;
		this.packetID = 103;
	}

}
