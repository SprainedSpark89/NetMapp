package io.github.SprainedSpark89.netmapp.version.java.release.r162;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketSignGui extends Packet {

	public PacketSignGui(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(Byte.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		
		this.argsDesc.add("Operation"); // 0 is just open it, even if the sign doesn't exist
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		
		this.packetID = 133;
		this.packetType = PacketType.signGui;
	}

}
