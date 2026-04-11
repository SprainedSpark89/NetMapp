package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w30c;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketTileEntityData extends Packet {

	public PacketTileEntityData(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(byte[].class);
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Data Type");
		this.argsDesc.add("NBT");
		
		this.packetID = 132;
		this.packetType = PacketType.tileEntityData;
	}

}
