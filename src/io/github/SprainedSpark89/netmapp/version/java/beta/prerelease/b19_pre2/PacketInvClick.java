package io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre2;

import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketInvClick extends Packet {

	public PacketInvClick(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Boolean.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(byte[].class);
		
		this.argsDesc.add("InvID");
		this.argsDesc.add("Slot");
		this.argsDesc.add("Click Type");
		this.argsDesc.add("Interaction ID");
		this.argsDesc.add("Shift Click");
		this.argsDesc.add("ItemID");
		this.argsDesc.add("Item Amount"); // only reads if id > -1
		this.argsDesc.add("Item Damage"); // only reads if id > -1
		this.argsDesc.add("NBT data length"); // HELL
		this.argsDesc.add("NBT data"); // HELL
		this.packetID = 102;
		this.packetType = PacketType.invClick;
		
		this.read = new SpecialRead(true, 6);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		byte amount = 0;
		short damage = 0;
		
		byte[] nbt = null;
		
		if((short)out.values.get(4) >= 0) {
			amount = (byte)NetMapp.parseArgs(out.packet, buf, Byte.TYPE, (short) 0);
			damage = (short)NetMapp.parseArgs(out.packet, buf, Short.TYPE, (short) 0);
			
			
			
			int itemEnd = buf.position();
			
			buf.mark();
			if (buf.remaining() >= Short.BYTES) {
				nbt = (byte[])NetMapp.parseArgs(out.packet, buf, byte[].class, (short)0);
				
			} else {
				buf.reset();
				buf.position(itemEnd);
			}
		}
		
		out.values.add(amount);
		desc.append("Byte: ").append(amount).append(", ");
		out.values.add(damage);
		desc.append("Short: ").append(damage).append(", ");
		out.values.add(nbt);
		if(nbt != null) {
			desc.append("ByteArray[").append(nbt.length).append("], ");
		} else {
			desc.append("ByteArray[").append("null").append("], ");
		}
		
	}

}
