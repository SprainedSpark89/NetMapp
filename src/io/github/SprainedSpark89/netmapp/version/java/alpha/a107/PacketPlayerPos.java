package io.github.SprainedSpark89.netmapp.version.java.alpha.a107;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketPlayerPos extends PacketFlying {

	public PacketPlayerPos(List<Class<?>> inputs, List<String> descriptions) {
		super();
		// TODO Auto-generated constructor stub
		this.args.add(Double.TYPE);
		this.args.add(Double.TYPE);
		this.args.add(Double.TYPE);
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		super.addExtra();
		this.packetID = 11;
		this.packetType = PacketType.playerPos;
	}

}
