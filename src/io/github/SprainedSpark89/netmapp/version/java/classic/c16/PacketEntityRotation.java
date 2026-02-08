package io.github.SprainedSpark89.netmapp.version.java.classic.c16;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketEntityRotation extends Packet {

	public PacketEntityRotation(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("PlayerID"); // player id
		this.argsDesc.add("XRot"); // client * this by 360 then divides this by 256
		this.argsDesc.add("YRot"); // client * this by 360 then divides this by 256
		this.packetType = PacketType.entityRot;
		this.packetID = 11;
	}

}
