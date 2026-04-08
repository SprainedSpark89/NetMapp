package io.github.SprainedSpark89.netmapp.version.java.beta.preview.b16_preview;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketRespawn extends Packet {

	public PacketRespawn(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		
		this.argsDesc.add("Dimension");
		
		this.packetType = PacketType.respawn;
		this.packetID = 9;
	}

}
