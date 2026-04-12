package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w04a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketScoreboardObjective extends Packet {

	public PacketScoreboardObjective(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(String.class);
		this.args.add(String.class);
		this.args.add(Byte.TYPE);
		
		this.argsDesc.add("Name");
		this.argsDesc.add("Display Name");
		this.argsDesc.add("Action");
		
		this.packetID = 206;
		this.packetType = PacketType.scoreboardObjective;
	}

}
