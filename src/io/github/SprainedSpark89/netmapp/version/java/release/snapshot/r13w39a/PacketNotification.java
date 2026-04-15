package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w39a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketNotification extends Packet {

	public PacketNotification(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(Byte.TYPE);
		this.args.add(Float.TYPE);
		this.argsDesc.add("Id");
		this.argsDesc.add("Data");
		
		this.packetID = 70;
		
		this.packetType = PacketType.notification;
		// TODO Auto-generated constructor stub
	}

}
