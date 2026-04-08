package io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre1;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketEffectAdd extends Packet {

	public PacketEffectAdd(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Short.TYPE);
		
		this.argsDesc.add("ID");
		this.argsDesc.add("Effect Id");
		this.argsDesc.add("Effect Strength");
		this.argsDesc.add("Effect Length");
		
		this.packetID = 41;
		
		this.packetType = PacketType.effectAdd;
	}

}
