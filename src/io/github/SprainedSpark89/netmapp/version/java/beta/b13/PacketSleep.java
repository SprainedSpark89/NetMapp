package io.github.SprainedSpark89.netmapp.version.java.beta.b13;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketSleep extends Packet {

	public PacketSleep(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Integer.TYPE);
		
		this.argsDesc.add("EntityID");
		this.argsDesc.add("Action");
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		
		this.packetID = 17;
		this.packetType = PacketType.sleep;
	}

}
