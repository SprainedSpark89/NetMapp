package io.github.SprainedSpark89.netmapp.version.java.alpha.a1010;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketChat extends Packet {

	public PacketChat(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(String.class);
		this.argsDesc.add("Chat Message");
		this.packetID = 3;
		this.packetType = PacketType.chat;
	}

}
