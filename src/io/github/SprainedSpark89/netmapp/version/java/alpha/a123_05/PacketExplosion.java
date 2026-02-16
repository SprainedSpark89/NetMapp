package io.github.SprainedSpark89.netmapp.version.java.alpha.a123_05;

import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketExplosion extends Packet {

	public PacketExplosion(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Double.TYPE);
		this.args.add(Double.TYPE);
		this.args.add(Double.TYPE);
		this.args.add(Float.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(byte[].class);
		this.args.add(byte[].class);
		this.args.add(byte[].class);
		this.argsDesc.add("Center X");
		this.argsDesc.add("Center Y");
		this.argsDesc.add("Center Z");
		this.argsDesc.add("Power");
		this.argsDesc.add("Blocks Damaged");
		this.argsDesc.add("Damaged Xs|ReadOrder:1");
		this.argsDesc.add("Damaged Ys|ReadOrder:2");
		this.argsDesc.add("Damaged Zs|ReadOrder:3");
		this.packetID = 60;
		this.packetType = PacketType.explosion;
		
		this.read = new SpecialRead(true, 4); // this sets it to read, and where to inject it's self
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		int blocks = (int)out.values.get(4);
		byte[] x = new byte[blocks];
		byte[] y = new byte[blocks];
		byte[] z = new byte[blocks];
		
		for(int i = 0; i < blocks; i++) {
			x[i] = (byte)NetMapp.parseArgs(this, buf, Byte.TYPE, (short) 0);		
			y[i] = (byte)NetMapp.parseArgs(this, buf, Byte.TYPE, (short) 0);
			z[i] = (byte)NetMapp.parseArgs(this, buf, Byte.TYPE, (short) 0);
		}
		
		out.values.add(x);
		desc.append("ByteArray[").append(blocks).append("], ");
		out.values.add(y);
		desc.append("ByteArray[").append(blocks).append("], ");
		out.values.add(z);
		desc.append("ByteArray[").append(blocks).append("], ");
	}
	

}
