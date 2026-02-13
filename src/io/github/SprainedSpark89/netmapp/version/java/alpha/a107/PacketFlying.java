package io.github.SprainedSpark89.netmapp.version.java.alpha.a107;

import java.util.ArrayList;
import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketFlying extends Packet {

	public PacketFlying(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.argsDesc.add("On Ground"); // 1 is on the ground
		this.packetType = PacketType.flying;
		this.packetID = 10;
	}
	
	public PacketFlying() {
		super(new ArrayList<Class<?>>(), new ArrayList<String>());
	}
	
	public void addExtra() {
		this.args.add(Byte.TYPE);
		this.argsDesc.add("On Ground"); // 1 is on the ground
	}
	
}
