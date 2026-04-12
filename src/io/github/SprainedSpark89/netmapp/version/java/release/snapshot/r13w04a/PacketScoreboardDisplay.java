package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w04a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketScoreboardDisplay extends Packet {

	public PacketScoreboardDisplay(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(String.class);
		
		this.argsDesc.add("Slot");
		this.argsDesc.add("Objective");
		
		this.packetID = 208;
		this.packetType = PacketType.scoreboardDisplay;
	}

}
