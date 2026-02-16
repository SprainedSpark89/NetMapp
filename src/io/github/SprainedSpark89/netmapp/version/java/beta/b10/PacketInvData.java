package io.github.SprainedSpark89.netmapp.version.java.beta.b10;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketInvData extends Packet {

	public PacketInvData(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.argsDesc.add("InvID");
		this.argsDesc.add("DataID");
		this.argsDesc.add("Value");
		this.packetID = 105;
		this.packetType = PacketType.setInvData;
	}

}
