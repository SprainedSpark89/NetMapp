package io.github.SprainedSpark89.netmapp.version.java.alpha.a109;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;

public class PacketItemSpawn extends Packet {

	public PacketItemSpawn(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("EntityID");
		this.argsDesc.add("ItemID");
		this.argsDesc.add("Item Count");
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Rot");
		this.argsDesc.add("Pitch");
		this.argsDesc.add("Yaw");
	}

}
