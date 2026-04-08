package io.github.SprainedSpark89.netmapp.version.java.beta.preview.b16_preview;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketMapData extends Packet {

	public PacketMapData(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Byte.TYPE); // & 0xFF
		this.args.add(byte[].class);
		
		this.argsDesc.add("Data Type");
		this.argsDesc.add("Data Id");
		this.argsDesc.add("Data Size");
		this.argsDesc.add("Data");
		
		this.packetID = 131;
		this.packetType = PacketType.mapData;
	}

}
