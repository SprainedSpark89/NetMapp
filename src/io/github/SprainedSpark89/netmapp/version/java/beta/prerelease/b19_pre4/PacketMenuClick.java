package io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre4;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketMenuClick extends Packet {

	public PacketMenuClick(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		
		this.argsDesc.add("Menu ID");
		this.argsDesc.add("Button ID");
		
		this.packetID = 108;
		this.packetType = PacketType.menuClick;
	}

}
