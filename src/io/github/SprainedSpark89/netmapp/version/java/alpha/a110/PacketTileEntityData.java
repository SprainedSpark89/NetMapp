package io.github.SprainedSpark89.netmapp.version.java.alpha.a110;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketTileEntityData extends Packet {

	public PacketTileEntityData(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(byte[].class);
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Compressed NBT Length");
		this.argsDesc.add("Compressed NBT");
		this.packetType = PacketType.tileEntityData;
		this.packetID = 59;
	}

}
