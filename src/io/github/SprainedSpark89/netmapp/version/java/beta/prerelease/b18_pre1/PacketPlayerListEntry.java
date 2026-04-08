package io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre1;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketPlayerListEntry extends Packet {

	public PacketPlayerListEntry(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(String.class);
		this.args.add(Byte.TYPE);
		this.args.add(Short.TYPE);
		
		this.argsDesc.add("Username");
		this.argsDesc.add("Add/Remove"); // 0 is false, everything else is true, tends to be 1 if true, true is add, false is remove
		this.argsDesc.add("Ping");
		
		this.packetID = 201;
		this.packetType = PacketType.playerListEntry;
	}

}
