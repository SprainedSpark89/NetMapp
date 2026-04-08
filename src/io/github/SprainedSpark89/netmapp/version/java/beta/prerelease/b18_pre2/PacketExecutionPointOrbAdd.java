package io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre2;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketExecutionPointOrbAdd extends Packet {

	public PacketExecutionPointOrbAdd(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE);
		
		this.argsDesc.add("Net id");
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Execution Point Amount");
		
		this.packetID = 26;
		this.packetType = PacketType.executionPointOrbAdd;
	}

}
