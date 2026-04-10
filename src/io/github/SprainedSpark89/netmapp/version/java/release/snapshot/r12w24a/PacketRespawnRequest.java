package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w24a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketRespawnRequest extends Packet {

	public PacketRespawnRequest(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("Client Play State");
		
		this.packetID = 205;
		this.packetType = PacketType.requestRespawn;
	}

}
