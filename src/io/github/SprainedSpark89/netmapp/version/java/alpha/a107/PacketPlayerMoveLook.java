package io.github.SprainedSpark89.netmapp.version.java.alpha.a107;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketPlayerMoveLook extends PacketFlying {
	
	public PacketPlayerMoveLook(List<Class<?>> inputs, List<String> descriptions) {
		super();
		// TODO Auto-generated constructor stub
		this.args.add(Double.TYPE);
		this.args.add(Double.TYPE);
		this.args.add(Double.TYPE);
		this.args.add(Float.TYPE);
		this.args.add(Float.TYPE);
		
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Yaw");
		this.argsDesc.add("Pitch");
		
		super.addExtra();
		this.packetID = 13;
		this.packetType = PacketType.entityMoveRot;
	}
}
