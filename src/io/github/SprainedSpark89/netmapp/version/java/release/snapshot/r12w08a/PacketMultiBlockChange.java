package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w08a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketMultiBlockChange extends Packet {

	public PacketMultiBlockChange(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE); // stored as an int, read with & 0xFFFF
		this.args.add(Integer.TYPE);
		this.args.add(byte[].class);
		this.argsDesc.add("X");
		this.argsDesc.add("Z");
		this.argsDesc.add("Change Amount");
		this.argsDesc.add("Coord Array Size");
		this.argsDesc.add("Coord Array");
		
		this.packetID = 52;
		this.packetType = PacketType.multiBlockUpdate;
	}

}
