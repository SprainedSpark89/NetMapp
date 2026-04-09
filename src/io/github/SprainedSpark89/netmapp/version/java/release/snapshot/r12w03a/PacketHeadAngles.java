package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w03a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketHeadAngles extends Packet {

	public PacketHeadAngles(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		
		this.argsDesc.add("Entity id");
		this.argsDesc.add("Head Yaw");
		
		this.packetID = 35;
		this.packetType = PacketType.headAngles;
	}

}
