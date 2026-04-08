package io.github.SprainedSpark89.netmapp.version.java.beta.test_build.b16_tb3;

import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketVehicleSpawn extends Packet {

	public PacketVehicleSpawn(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		
		this.argsDesc.add("EntityID");
		this.argsDesc.add("VehicleType");
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Data");
		this.argsDesc.add("X Vel"); // only read when data > 0
		this.argsDesc.add("Y Vel"); // only read when data > 0
		this.argsDesc.add("Z Vel"); // only read when data > 0
		this.packetID = 23;
		this.packetType = PacketType.vehicleSpawn;
		
		this.read = new SpecialRead(true, 6);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		float velX = 0;
		float velY = 0;
		float velZ = 0;
		if((int)out.values.get(5) > 0) {
			velX = (float)NetMapp.parseArgs(out.packet, buf, Float.TYPE, (short) 0);
			velY = (float)NetMapp.parseArgs(out.packet, buf, Float.TYPE, (short) 0);
			velZ = (float)NetMapp.parseArgs(out.packet, buf, Float.TYPE, (short) 0);
		}
		
		out.values.add(velX);
		desc.append("Float: ").append(velX).append(", ");
		out.values.add(velY);
		desc.append("Float: ").append(velY).append(", ");
		out.values.add(velZ);
		desc.append("Float: ").append(velZ).append(", ");
	}

}
