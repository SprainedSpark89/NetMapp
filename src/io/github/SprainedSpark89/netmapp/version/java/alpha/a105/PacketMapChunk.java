package io.github.SprainedSpark89.netmapp.version.java.alpha.a105;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketMapChunk extends Packet {

	public PacketMapChunk(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(byte[].class);
		this.args.add(Integer.TYPE);
		this.packetID = 10;
		this.packetType = PacketType.worldData;
	}

}
