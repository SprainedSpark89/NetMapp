package io.github.SprainedSpark89.netmapp.version.LCE.v1._3._0494._0;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketKeepAlive extends Packet {

	public PacketKeepAlive(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.packetID = 0;
		this.packetType = PacketType.keepAlive;
	}

}
