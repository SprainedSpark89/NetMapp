package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w04a;

import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketScoreboardScore extends Packet {

	public PacketScoreboardScore(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(String.class);
		this.args.add(Byte.TYPE);
		this.args.add(String.class);
		this.args.add(Integer.TYPE);
		
		this.argsDesc.add("Owner");
		this.argsDesc.add("Update Mode");
		this.argsDesc.add("Objective");
		this.argsDesc.add("Score");
		
		this.packetID = 207;
		this.packetType = PacketType.scoreboardScore;
		
		this.read = new SpecialRead(true, 2);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		String objective = null;
		int score = (int) Float.NaN;
		if((byte)out.values.get(1) != 1) {
			objective = (String)NetMapp.parseArgs(out.packet, buf, String.class, (short) 0);
			score = (int)NetMapp.parseArgs(out.packet, buf, Integer.TYPE, (short) 0);
		}
		out.values.add(objective);
		desc.append("String: \"").append(objective).append("\", ");
		out.values.add(score);
		desc.append("Integer: ").append(score).append(", ");
	}

}
