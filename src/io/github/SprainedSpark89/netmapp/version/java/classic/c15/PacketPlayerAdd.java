package io.github.SprainedSpark89.netmapp.version.java.classic.c15;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketPlayerAdd extends Packet { // player join, not the login, just another player joining the server
	// also can set the target player's cords if the id is less than 0

	public PacketPlayerAdd(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(String.class);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("PlayerID"); // player id
		this.argsDesc.add("Username");
		this.argsDesc.add("X"); // client divides this by 32
		this.argsDesc.add("Y"); // client divides this by 32
		this.argsDesc.add("Z"); // client divides this by 32
		this.argsDesc.add("XRot"); // client * this by 360 then divides this by 256
		this.argsDesc.add("YRot"); // client * this by 360 then divides this by 256
		this.packetType = PacketType.entityJoin;
	}

}
