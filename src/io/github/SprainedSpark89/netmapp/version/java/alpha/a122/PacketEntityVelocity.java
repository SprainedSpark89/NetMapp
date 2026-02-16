package io.github.SprainedSpark89.netmapp.version.java.alpha.a122;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketEntityVelocity extends Packet {

	public PacketEntityVelocity(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		
		// these are all capped at 0.9 in both directions (.9 and -.9)
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.argsDesc.add("EntityID");
		this.argsDesc.add("X Vel"); // double, * 32000, int casted, then short casted
		this.argsDesc.add("Y Vel"); // double, * 32000, int casted, then short casted
		this.argsDesc.add("Z Vel"); // double, * 32000, int casted, then short casted
		this.packetType = PacketType.entityVel;
		this.packetID = 28;
	}

}
