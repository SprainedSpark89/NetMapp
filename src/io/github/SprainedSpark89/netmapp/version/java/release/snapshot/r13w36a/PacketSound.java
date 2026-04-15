package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w36a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;

public class PacketSound extends Packet {

	public PacketSound(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(String.class);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Float.TYPE);
		this.args.add(Byte.TYPE); // unsigned
		this.args.add(Byte.TYPE);
		
		this.argsDesc.add("Sound Id");
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Volume");
		this.argsDesc.add("Pitch");
		this.argsDesc.add("Category Id");
	}

}
