package io.github.SprainedSpark89.netmapp.version.java.alpha.a107;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketPlayerLook extends PacketFlying {
	
	public PacketPlayerLook(List<Class<?>> inputs, List<String> descriptions) {
		super();
		// TODO Auto-generated constructor stub
		this.args.add(Float.TYPE);
		this.args.add(Float.TYPE);
		this.argsDesc.add("Yaw");
		this.argsDesc.add("Pitch");
		super.addExtra();
		this.packetID = 12;
		this.packetType = PacketType.playerLook;
	}

}
