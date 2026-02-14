package io.github.SprainedSpark89.netmapp.version.java.alpha.a1013;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketEntity;
/**
 * I don't question the Packet, it wouldn't do any good if you did either
 * Interrogation got me nowhere
 */
public class PacketEntityLook extends PacketEntity { // I don't know why
	// packet takes in yaw and pitch, but it writes cords, as bytes...
	public PacketEntityLook(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.packetID = 32;
		this.packetType = PacketType.entityRot;
	}

}
