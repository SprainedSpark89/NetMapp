package io.github.SprainedSpark89.netmapp.version.java.alpha.a1010;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketCollect extends Packet {

	public PacketCollect(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.argsDesc.add("EntityID Collected");
		this.argsDesc.add("EntityID Collector");
		this.packetType = PacketType.entityCollect;
		this.packetID = 22;
	}

}
