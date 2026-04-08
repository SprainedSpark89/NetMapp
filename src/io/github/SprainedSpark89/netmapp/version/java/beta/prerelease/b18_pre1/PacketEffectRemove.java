package io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre1;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketEffectRemove extends Packet {

	public PacketEffectRemove(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		
		this.argsDesc.add("Id");
		this.argsDesc.add("Effect ID");
		
		this.packetID = 42;
		this.packetType = PacketType.effectRemove;
	}

}
