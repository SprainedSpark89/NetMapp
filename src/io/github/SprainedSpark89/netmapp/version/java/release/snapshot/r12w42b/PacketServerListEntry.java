package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w42b;

import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketServerListEntry extends Packet {

	public PacketServerListEntry(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("Ping");
		// TODO Auto-generated constructor stub
		this.packetID = 254;
		this.packetType = PacketType.serverListEntry;
		this.read = new SpecialRead(true, 0);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) { // there's literally no packet write for this 
		int packetStartPos = buf.position();
		byte ping;
		buf.mark();
		if (buf.remaining() >= Byte.BYTES) {
			ping = (byte)NetMapp.parseArgs(out.packet, buf, Byte.TYPE, (short) 0);
		} else {
			buf.reset();
			buf.position(packetStartPos);
			ping = 0;
		}
		
		out.values.add(ping);
		desc.append("Byte: ").append(ping).append(", ");
	}

}
