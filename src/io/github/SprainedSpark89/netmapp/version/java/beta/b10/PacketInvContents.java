package io.github.SprainedSpark89.netmapp.version.java.beta.b10;

import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketInvContents extends Packet {

	public PacketInvContents(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(short[].class);
		this.args.add(byte[].class);
		this.args.add(short[].class);
		this.argsDesc.add("Inv ID");
		this.argsDesc.add("Inv Length");
		this.argsDesc.add("ItemID|ReadOrder:1");
		this.argsDesc.add("Item Amount|ReadOrder:2");
		this.argsDesc.add("Item Damage|ReadOrder:3");
		/*
		 * Read Order is how it's read:
		 * example:
		 * These get read into an item stack array which take the args of:
		 * id, amount, and damage
		 * these are written in a loop where the id of the item is written first
		 * amount second, and damage third
		 * these are not separate and are written together, so SHORT,BYTE,SHORT
		 * the length is how many items, and if the item id is -1, the amount and damage
		 * are not written
		 */
		
		this.packetID = 104;
		this.packetType = PacketType.setInventory;
		this.read = new SpecialRead(true, 2); // this sets it to read, and where to inject it's self
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		short length = (short) out.values.get(1);
		short[] itemIDs = new short[length];
		byte[] amount = new byte[length];
		short[] damage = new short[length];
		for(int i = 0; i < length; i++) {
			itemIDs[i] = (short)NetMapp.parseArgs(this, buf, Short.TYPE, (short) 0);
			if(itemIDs[i] >= 0) {
				amount[i] = (byte)NetMapp.parseArgs(this, buf, Byte.TYPE, (short) 0);
				damage[i] = (short)NetMapp.parseArgs(this, buf, Short.TYPE, (short) 0);
			}
		}
		
		out.values.add(itemIDs);
		desc.append("ShortArray[").append(length).append("], ");
		out.values.add(amount);
		desc.append("ByteArray[").append(length).append("], ");
		out.values.add(damage);
		desc.append("ShortArray[").append(length).append("], ");
	}

}
