package io.github.SprainedSpark89.netmapp.version.java.beta.b12;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketPlayerActionChange extends Packet {

	public PacketPlayerActionChange(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("EntityId");
		this.argsDesc.add("Action");
		this.packetID = 19;
		this.packetType = PacketType.actionChange;
	}

}
