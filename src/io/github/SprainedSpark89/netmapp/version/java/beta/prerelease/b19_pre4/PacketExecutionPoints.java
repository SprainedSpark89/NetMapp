package io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre4;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketExecutionPoints extends Packet { // Undertale reference, hopefully not a Deltarune one... wait a minute... is that... oh god

	public PacketExecutionPoints(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(Float.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		
		this.argsDesc.add("Next Level of Violence");
		this.argsDesc.add("Level of Violence");
		this.argsDesc.add("Execution Points");
		
		this.packetID = 43;
		this.packetType = PacketType.executionPoints;
	}

}
