package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w23a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketMiningProgress extends Packet {

	public PacketMiningProgress(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		
		this.argsDesc.add("ID");
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Progress");
		
		this.packetID = 55;
		this.packetType = PacketType.miningProgress;
	}

}
