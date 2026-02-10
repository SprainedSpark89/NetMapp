package io.github.SprainedSpark89.netmapp.version.java.alpha.a106;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketNamedEntitySpawn extends Packet {

	public PacketNamedEntitySpawn(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(String.class);
		this.args.add(Integer.TYPE); // this is set to the value *32 then floor doubled
		this.args.add(Integer.TYPE); // this is set to the value *32 then floor doubled
		this.args.add(Integer.TYPE); // this is set to the value *32 then floor doubled	
		this.args.add(Byte.TYPE); // this is set to the value *256, /360, int casted, then byte 
		this.args.add(Byte.TYPE); // this is set to the value *256, /360, int casted, then byte
		this.args.add(Short.TYPE); // this CANNOT BE 36, set it to 0 if it has to be
		this.argsDesc.add("EntityID");
		this.argsDesc.add("Name");
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Rot");
		this.argsDesc.add("Pitch");
		this.argsDesc.add("Held Item ID"); // null is 0
		this.packetID = 2;
		this.packetType = PacketType.namedEntitySpawn;
	}

}
