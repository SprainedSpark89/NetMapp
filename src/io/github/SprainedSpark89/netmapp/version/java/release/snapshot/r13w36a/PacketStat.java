package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w36a;

import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketStat extends Packet {

	public PacketStat(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(String[].class);
		this.args.add(int[].class);
		
		this.argsDesc.add("Stat list Length");
		this.argsDesc.add("Stats");
		this.argsDesc.add("Values");
		
		this.packetID = 200;
		this.packetType = PacketType.stat;
		
		this.read = new SpecialRead(true, 1);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		int size = (int)out.values.get(0);
		String[] stats = new String[size];
		int[] values = new int[size];
		for(int i = 0; i < size; i++) {
			stats[i] = (String)NetMapp.parseArgs(out.packet, buf, String.class, (short) 0);
			values[i] = (int)NetMapp.parseArgs(out.packet, buf, Integer.TYPE, (short) 0);
		}
		
		out.values.add(stats);
		desc.append("StringArray[").append(stats.length).append("], ");
		out.values.add(values);
		desc.append("StringArray[").append(values.length).append("], ");
	}

}
