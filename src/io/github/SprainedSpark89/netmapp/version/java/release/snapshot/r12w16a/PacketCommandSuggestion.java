package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w16a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketCommandSuggestion extends Packet {

	public PacketCommandSuggestion(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(String.class);
		this.argsDesc.add("Command");
		
		this.packetID = 203;
		this.packetType = PacketType.commandSuggestion;
	}

}
