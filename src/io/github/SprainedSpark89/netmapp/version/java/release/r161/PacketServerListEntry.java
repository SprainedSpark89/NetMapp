package io.github.SprainedSpark89.netmapp.version.java.release.r161;

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
		this.args.add(Byte.TYPE);
		this.args.add(String.class);
		this.args.add(Short.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(String.class);
		this.args.add(Integer.TYPE);
		
		this.argsDesc.add("1");
		this.argsDesc.add("PacketModPluginDataTransfer ID");
		this.argsDesc.add("Ping Header");
		this.argsDesc.add("Packet Size");
		this.argsDesc.add("Protocol");
		this.argsDesc.add("IP");
		this.argsDesc.add("Port");
		
		// TODO Auto-generated constructor stub
		this.packetID = 254;
		this.packetType = PacketType.serverListEntry;
		this.read = new SpecialRead(true, 5);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		String ip = null;
		int port = 0;
		if((byte)out.values.get(4) >= 73) {
			ip = (String)NetMapp.parseArgs(out.packet, buf, String.class, (short) 0);
			port = (int)NetMapp.parseArgs(out.packet, buf, Integer.TYPE, (short) 0);
		}
		
		out.values.add(ip);
		desc.append("String: \"").append(ip).append("\", ");
		out.values.add(port);
		desc.append("Integer: ").append(port).append(", ");
	}

}
