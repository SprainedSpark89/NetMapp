package io.github.SprainedSpark89.netmapp.version.java.beta.b13;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketPlayerInput extends Packet {

	public PacketPlayerInput(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Float.TYPE);
		this.args.add(Float.TYPE);
		this.args.add(Float.TYPE);
		this.args.add(Float.TYPE);
		this.args.add(Boolean.TYPE);
		this.args.add(Boolean.TYPE);
		
		this.argsDesc.add("Sideways Speed");
		this.argsDesc.add("Forward Speed");
		this.argsDesc.add("Pitch");
		this.argsDesc.add("Yaw");
		this.argsDesc.add("Jumping");
		this.argsDesc.add("Sneaking");
		
		this.packetID = 27;
		this.packetType = PacketType.playerInput;
	}

}
