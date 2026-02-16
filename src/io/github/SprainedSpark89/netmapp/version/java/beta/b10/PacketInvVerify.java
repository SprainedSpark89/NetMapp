package io.github.SprainedSpark89.netmapp.version.java.beta.b10;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketInvVerify extends Packet {

	public PacketInvVerify(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("InvID");
		this.argsDesc.add("Interaction ID");
		this.argsDesc.add("Undo"); // Undoes what's done if == to 0
		this.packetID = 106;
		this.packetType = PacketType.invCheck;
	}

}
