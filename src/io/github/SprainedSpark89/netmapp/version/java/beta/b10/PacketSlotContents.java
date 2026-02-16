package io.github.SprainedSpark89.netmapp.version.java.beta.b10;

import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketSlotContents extends Packet {

	public PacketSlotContents(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("InvID");
		this.argsDesc.add("Slot");
		this.argsDesc.add("ItemID");
		this.argsDesc.add("Item Amount"); // only reads if id > -1
		this.argsDesc.add("Item Damage"); // only reads if id > -1
		this.packetType = PacketType.slotContents;
		this.packetID = 103;
		
		this.read = new SpecialRead(true, 3);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		byte amount = 0;
		byte damage = 0;
		if((short)out.values.get(2) >= 0) {
			amount = (byte)NetMapp.parseArgs(out.packet, buf, Byte.TYPE, (short) 0);
			damage = (byte)NetMapp.parseArgs(out.packet, buf, Byte.TYPE, (short) 0);
		}
		
		out.values.add(amount);
		desc.append("Byte: ").append(amount).append(", ");
		out.values.add(damage);
		desc.append("Byte: ").append(damage).append(", ");
	}

}
