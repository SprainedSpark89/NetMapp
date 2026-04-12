package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w09c;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketParticles extends Packet {

	public PacketParticles(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(String.class);
		this.args.add(Float.TYPE);
		this.args.add(Float.TYPE);
		this.args.add(Float.TYPE);
		this.args.add(Float.TYPE);
		this.args.add(Float.TYPE);
		this.args.add(Float.TYPE);
		this.args.add(Float.TYPE);
		this.args.add(Integer.TYPE);
		
		this.argsDesc.add("Particle Type");
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Vel X");
		this.argsDesc.add("Vel Y");
		this.argsDesc.add("Vel Z");
		this.argsDesc.add("Vel Scale");
		this.argsDesc.add("Amount");
		
		this.packetID = 63;
		this.packetType = PacketType.particles;
	}

}
