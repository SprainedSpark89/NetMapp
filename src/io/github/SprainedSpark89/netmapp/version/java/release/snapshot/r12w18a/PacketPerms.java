package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w18a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketPerms extends Packet {

	public PacketPerms(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		
		this.argsDesc.add("Invincible/Currently Flying/Can Fly/Can Switch to Creative");
		/*
			Invincible & 1 > 0
			Currently Flying & 2 > 0
			Can Fly & 4 > 0
			Can Switch to Creative & 8 > 0
		*/
		this.argsDesc.add("Flying Speed");
		this.argsDesc.add("Walking Speed");
		
		this.packetID = 202;
		
		this.packetType = PacketType.userPerms;
	}

}
