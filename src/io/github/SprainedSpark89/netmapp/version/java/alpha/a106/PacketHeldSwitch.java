package io.github.SprainedSpark89.netmapp.version.java.alpha.a106;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketHeldSwitch extends Packet {

	public PacketHeldSwitch(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE);
		this.argsDesc.add("EntityID");
		this.argsDesc.add("ItemID");
		this.packetID = 52;
		this.packetType = PacketType.handSwap;
	}

}
