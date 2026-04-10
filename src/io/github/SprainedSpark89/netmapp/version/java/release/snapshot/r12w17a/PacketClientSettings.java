package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w17a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketClientSettings extends Packet {

	public PacketClientSettings(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(String.class);
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		
		this.argsDesc.add("Lang");
		this.argsDesc.add("Render Distance");
		this.argsDesc.add("Chat Options");
		
		this.packetID = 204;
		
		this.packetType = PacketType.clientSettings;
	}

}
