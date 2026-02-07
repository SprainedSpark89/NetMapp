package io.github.SprainedSpark89.netmapp.version.java.classic.c15;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketBlockUpdate extends Packet {

	public PacketBlockUpdate(List<Class<?>> inputs, List<String> descriptions) { // it's a block either place or broke thing, but i think this works as the name
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Edit Mode"); // i don't know
		this.argsDesc.add("Paint Texture"); // why is this being sent to the server?
		this.packetType = PacketType.blockUpdate;
		this.packetID = 4;
	}

}
