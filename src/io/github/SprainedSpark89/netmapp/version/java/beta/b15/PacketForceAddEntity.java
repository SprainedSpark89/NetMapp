package io.github.SprainedSpark89.netmapp.version.java.beta.b15;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketForceAddEntity extends Packet {

	public PacketForceAddEntity(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		
		this.argsDesc.add("EntityID");
		this.argsDesc.add("Entity Type");
		this.argsDesc.add("X"); // sends: floored(x*32)
		this.argsDesc.add("Y"); // sends: floored(y*32)
		this.argsDesc.add("Z"); // sends: floored(z*32)
		
		this.packetID = 71;
		this.packetType = PacketType.forceAddEntity;
	}

}
