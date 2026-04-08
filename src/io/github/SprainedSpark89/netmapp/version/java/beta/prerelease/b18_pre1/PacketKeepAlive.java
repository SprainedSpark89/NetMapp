package io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre1;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketKeepAlive extends Packet {
	public PacketKeepAlive(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		
		this.argsDesc.add("Time in Mills");
		
		this.packetID = 0;
		this.packetType = PacketType.keepAlive;
	}
}
