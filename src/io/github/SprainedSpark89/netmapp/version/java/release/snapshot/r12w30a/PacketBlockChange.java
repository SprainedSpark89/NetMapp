package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w30a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketBlockChange extends Packet {

	public PacketBlockChange(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("BlockID");
		this.argsDesc.add("MetaData");
		this.packetID = 53;
		this.packetType = PacketType.blockUpdate;
	}

}
