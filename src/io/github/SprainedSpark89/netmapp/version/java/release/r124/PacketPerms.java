package io.github.SprainedSpark89.netmapp.version.java.release.r124;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketPerms extends Packet {

	public PacketPerms(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(Boolean.TYPE);
		this.args.add(Boolean.TYPE);
		this.args.add(Boolean.TYPE);
		this.args.add(Boolean.TYPE);
		
		this.argsDesc.add("Invincible");
		this.argsDesc.add("Currently Flying");
		this.argsDesc.add("Can Fly");
		this.argsDesc.add("Can Switch to Creative");
		
		this.packetID = 202;
		
		this.packetType = PacketType.userPerms;
	}

}
