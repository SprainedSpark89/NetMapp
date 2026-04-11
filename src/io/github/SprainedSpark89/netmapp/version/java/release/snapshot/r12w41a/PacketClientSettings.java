package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w41a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketClientSettings extends Packet {

	public PacketClientSettings(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(String.class);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Boolean.TYPE);
		
		this.argsDesc.add("Lang");
		this.argsDesc.add("Render Distance");
		this.argsDesc.add("Chat Options");
		this.argsDesc.add("Difficulty");
		this.argsDesc.add("Show Cape");
		
		this.packetID = 204;
		
		this.packetType = PacketType.clientSettings;
	}

}
