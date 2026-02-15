package io.github.SprainedSpark89.netmapp.version.java.alpha.a1015;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketAnimate extends Packet {

	public PacketAnimate(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("EntityID");
		this.argsDesc.add("Animation");
		this.packetID = 18;
		this.packetType = PacketType.animate;
	}

}
