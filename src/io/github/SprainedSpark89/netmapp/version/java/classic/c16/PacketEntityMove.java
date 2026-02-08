package io.github.SprainedSpark89.netmapp.version.java.classic.c16;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketEntityMove extends Packet {

	public PacketEntityMove(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("PlayerID"); // player id
		this.argsDesc.add("X"); // client divides this by 32
		this.argsDesc.add("Y"); // client divides this by 32
		this.argsDesc.add("Z"); // client divides this by 32
		this.packetType = PacketType.entityMove;
		this.packetID = 10;
	}

}
