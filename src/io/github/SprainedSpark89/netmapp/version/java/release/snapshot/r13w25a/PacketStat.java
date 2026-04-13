package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w25a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketStat extends Packet {

	public PacketStat(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		
		this.argsDesc.add("id");
		this.argsDesc.add("value");
		
		this.packetID = 200;
		this.packetType = PacketType.stat;
	}

}
