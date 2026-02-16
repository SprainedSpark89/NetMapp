package io.github.SprainedSpark89.netmapp.version.java.beta.b10;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketOpenInv extends Packet {

	public PacketOpenInv(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(String.class);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("MenuID");
		this.argsDesc.add("Menu Type");
		this.argsDesc.add("Displayed Name");
		this.argsDesc.add("Size");
		this.packetID = 100;
		this.packetType = PacketType.openInv;
	}

}
