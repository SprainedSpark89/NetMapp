package io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketPlayerMoveLook extends Packet {

	public PacketPlayerMoveLook(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Double.TYPE);
		this.args.add(Double.TYPE);
		this.args.add(Double.TYPE);
		this.args.add(Float.TYPE);
		this.args.add(Float.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Yaw");
		this.argsDesc.add("Pitch");
		this.argsDesc.add("Mode");
		this.packetID = 1;
		this.packetType = PacketType.entityMoveRot;
	}

}
