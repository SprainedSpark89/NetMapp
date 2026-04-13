package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w21a;

import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketOpenInv extends Packet {

	public PacketOpenInv(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(String.class);
		this.args.add(Byte.TYPE);
		this.args.add(Integer.TYPE);
		this.argsDesc.add("MenuID");
		this.argsDesc.add("Menu Type");
		this.argsDesc.add("Displayed Name");
		this.argsDesc.add("Size");
		this.argsDesc.add("Owner ID");
		this.packetID = 100;
		this.packetType = PacketType.openInv;
		
		this.read = new SpecialRead(true, 5);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		int owner = 0;
		if(((byte)out.values.get(1) & 0xFF) == 11) {
			owner = (int)NetMapp.parseArgs(out.packet, buf, Integer.TYPE, (short) 0);
		}
		
		out.values.add(owner);
		desc.append("Integer: ").append(owner).append(", ");
	}

}
