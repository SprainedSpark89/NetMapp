package io.github.SprainedSpark89.netmapp.version.java.alpha.a1010;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketAddToInv extends Packet {

	public PacketAddToInv(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Short.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Short.TYPE);
		this.argsDesc.add("ItemID");
		this.argsDesc.add("Item Amount");
		this.argsDesc.add("Item Damage");
		this.packetID = 17;
		this.packetType = PacketType.itemInvAdd;
	}

}
