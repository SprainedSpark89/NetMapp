package io.github.SprainedSpark89.netmapp.version.java.beta.b15;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketStat extends Packet {

	public PacketStat(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		
		this.argsDesc.add("id");
		this.argsDesc.add("value");
		
		this.packetID = 200;
		this.packetType = PacketType.stat;
	}

}
