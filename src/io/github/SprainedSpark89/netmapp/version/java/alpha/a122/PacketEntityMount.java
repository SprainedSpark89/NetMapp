package io.github.SprainedSpark89.netmapp.version.java.alpha.a122;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketEntityMount extends Packet {

	public PacketEntityMount(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE); // -1 dismount, or just not a valid entityid
		this.argsDesc.add("EntityID (Rider)");
		this.argsDesc.add("EntityID (Victim)");
		this.packetType = PacketType.entitySit;
		this.packetID = 39;
	}

}
