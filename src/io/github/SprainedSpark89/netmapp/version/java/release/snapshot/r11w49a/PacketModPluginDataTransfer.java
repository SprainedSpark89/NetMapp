package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r11w49a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketModPluginDataTransfer extends Packet { // not entirely sure what this packet does, it's mostly unused in 11w49a

	public PacketModPluginDataTransfer(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(String.class);
		this.args.add(Short.TYPE);
		this.args.add(byte[].class);
		
		this.argsDesc.add("Text");
		this.argsDesc.add("Data Length");
		this.argsDesc.add("Data");
		
		this.packetID = 250;
		this.packetType = PacketType.modPluginData;
	}

}
