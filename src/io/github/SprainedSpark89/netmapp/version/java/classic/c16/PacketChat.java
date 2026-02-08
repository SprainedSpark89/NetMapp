package io.github.SprainedSpark89.netmapp.version.java.classic.c16;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketChat extends Packet {

	public PacketChat(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(String.class);
		this.argsDesc.add("PlayerID");
		this.argsDesc.add("Chat Message");
		this.packetID = 13;
		this.packetType = PacketType.chat;
	}
}
