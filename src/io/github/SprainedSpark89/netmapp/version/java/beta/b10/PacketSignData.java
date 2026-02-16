package io.github.SprainedSpark89.netmapp.version.java.beta.b10;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketSignData extends Packet {

	public PacketSignData(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(String.class);
		this.args.add(String.class);
		this.args.add(String.class);
		this.args.add(String.class);
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Line1");
		this.argsDesc.add("Line2");
		this.argsDesc.add("Line3");
		this.argsDesc.add("Line4");
		this.packetID = 130;
		this.packetType = PacketType.signData;
	}

}
