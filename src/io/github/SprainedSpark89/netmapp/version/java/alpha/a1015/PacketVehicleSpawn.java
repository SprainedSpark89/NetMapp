package io.github.SprainedSpark89.netmapp.version.java.alpha.a1015;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketVehicleSpawn extends Packet {

	public PacketVehicleSpawn(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.argsDesc.add("EntityID");
		this.argsDesc.add("VehicleType");
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.packetID = 23;
		this.packetType = PacketType.vehicleSpawn;
	}

}
