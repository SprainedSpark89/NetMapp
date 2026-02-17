package io.github.SprainedSpark89.netmapp.version.java.beta.b12;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketPaintingSpawn extends Packet {

	public PacketPaintingSpawn(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(String.class);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.argsDesc.add("EntityID");
		this.argsDesc.add("PaintingName");
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Facing");
		this.packetID = 25;
		this.packetType = PacketType.spawnPainting;
	}

}
