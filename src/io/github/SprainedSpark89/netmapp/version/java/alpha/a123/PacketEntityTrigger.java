package io.github.SprainedSpark89.netmapp.version.java.alpha.a123;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketEntityTrigger extends Packet {

	public PacketEntityTrigger(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("EntityID");
		this.argsDesc.add("TriggerID");
		this.packetID = 38;
		this.packetType = PacketType.entityTrigger;
	}

}
