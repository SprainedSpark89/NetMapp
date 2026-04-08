package io.github.SprainedSpark89.netmapp.version.java.beta.test_build.b16_tb3;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketBlockUpdate extends Packet {

	public PacketBlockUpdate(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		
		this.argsDesc.add("Event ID");
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Data");
		
		this.packetID = 61;
		this.packetType = PacketType.updateBlock;
	}

}
