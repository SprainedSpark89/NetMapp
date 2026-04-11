package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w34b;

import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketItemSpawn extends Packet {

	public PacketItemSpawn(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(byte[].class);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.argsDesc.add("EntityID");
		this.argsDesc.add("ItemID");
		this.argsDesc.add("Item Count");
		this.argsDesc.add("Item Damage");
		
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Rot");
		this.argsDesc.add("Pitch");
		this.argsDesc.add("Yaw");
		this.packetID = 21;
		this.packetType = PacketType.itemDrop;
		this.read = new SpecialRead(true, 2);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		byte amount = 0;
		short damage = 0;
		
		byte[] nbt = null;
		
		if((short)out.values.get(1) >= 0) {
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
		
		int i;
		out.values.add((i = (int)NetMapp.parseArgs(out.packet, buf, Integer.TYPE, (short) 0)));
		desc.append("Integer: ").append(i).append(", ");
		out.values.add((i = (int)NetMapp.parseArgs(out.packet, buf, Integer.TYPE, (short) 0)));
		desc.append("Integer: ").append(i).append(", ");
		out.values.add((i = (int)NetMapp.parseArgs(out.packet, buf, Integer.TYPE, (short) 0)));
		desc.append("Integer: ").append(i).append(", ");
		byte b;
		out.values.add((b = (byte)NetMapp.parseArgs(out.packet, buf, Byte.TYPE, (short) 0)));
		desc.append("Byte: ").append(b).append(", ");
		out.values.add((b = (byte)NetMapp.parseArgs(out.packet, buf, Byte.TYPE, (short) 0)));
		desc.append("Byte: ").append(b).append(", ");
		out.values.add((b = (byte)NetMapp.parseArgs(out.packet, buf, Byte.TYPE, (short) 0)));
		desc.append("Byte: ").append(b).append(", ");
	}

}
