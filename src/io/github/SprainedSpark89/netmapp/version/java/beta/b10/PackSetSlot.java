package io.github.SprainedSpark89.netmapp.version.java.beta.b10;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PackSetSlot extends Packet {

	public PackSetSlot(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.argsDesc.add("EntityID");
		this.argsDesc.add("Slot");
		this.argsDesc.add("ItemID");
		this.packetID = 5;
		this.packetType = PacketType.setInventory;
	}

}
