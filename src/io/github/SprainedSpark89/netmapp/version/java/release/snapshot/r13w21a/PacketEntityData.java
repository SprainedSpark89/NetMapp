package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w21a;

import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketEntityData extends Packet {

	public PacketEntityData(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(String[].class);
		this.args.add(double[].class);
		
		this.argsDesc.add("Entity ID");
		this.argsDesc.add("Data Entries");
		this.argsDesc.add("Data Keys");
		this.argsDesc.add("Data Values");
		
		this.packetID = 44;
		
		this.packetType = PacketType.entityData;
		
		this.read = new SpecialRead(true, 2);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		int size = (int) out.values.get(1);
		String[] keys = new String[size];
		double[] values = new double[size];
		
		for(int i = 0; i < size; i++) {
			keys[i] = (String)NetMapp.parseArgs(out.packet, buf, String.class, (short) 0);
			values[i] = (double)NetMapp.parseArgs(out.packet, buf, Double.TYPE, (short) 0);
		}
		
		out.values.add(keys);
		desc.append("StringArray[").append(keys.length).append("], ");
		out.values.add(values);
		desc.append("DoubleArray[").append(values.length).append("], ");
	}

}
