package io.github.SprainedSpark89.netmapp.version.java.alpha.a105;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketKickDisconnect extends Packet {

	public PacketKickDisconnect(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(String.class);
		this.argsDesc.add("Reason");
		this.packetID = 255;
		this.packetType = PacketType.kick;
	}

}
