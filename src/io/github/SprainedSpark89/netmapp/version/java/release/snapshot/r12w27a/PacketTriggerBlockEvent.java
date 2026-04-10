package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w27a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketTriggerBlockEvent extends Packet {

	public PacketTriggerBlockEvent(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Short.TYPE);
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Type");
		this.argsDesc.add("Data");
		this.argsDesc.add("Block ID");
		this.packetID = 54;
		this.packetType = PacketType.blockEventTrigger;
	}

}
