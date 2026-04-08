package io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre1;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketCreativeMenuSlot extends Packet {

	public PacketCreativeMenuSlot(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		
		this.argsDesc.add("Slot");
		this.argsDesc.add("Item id");
		this.argsDesc.add("Size");
		this.argsDesc.add("Damage");
		
		this.packetID = 107;
		this.packetType = PacketType.creativeSlot;
	}

}
