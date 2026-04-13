package io.github.SprainedSpark89.netmapp.version.java.release.r162;

import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketEntityData extends Packet {

	public PacketEntityData(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(String[].class);
		this.args.add(double[].class);
		this.args.add(short[].class);
		this.args.add(long[][].class);
		this.args.add(long[][].class);
		this.args.add(double[][].class);
		this.args.add(byte[][].class);
		
		this.argsDesc.add("Entity ID");
		this.argsDesc.add("Data Entries");
		this.argsDesc.add("Data Keys");
		this.argsDesc.add("Data Values");
		this.argsDesc.add("Modifiers");
		this.argsDesc.add("ID Most Sig Bits");
		this.argsDesc.add("ID Least Sig Bits");
		this.argsDesc.add("Modifier");
		this.argsDesc.add("Operation");
		
		this.packetID = 44;
		
		this.packetType = PacketType.entityData;
		
		this.read = new SpecialRead(true, 2);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		int size = (int) out.values.get(1);
		String[] keys = new String[size];
		double[] values = new double[size];
		short[] modifiers = new short[size];
		long[][] most = new long[size][];
		long[][] least = new long[size][];
		double[][] modifier = new double[size][];
		byte[][] operation = new byte[size][];
		
		for(int i = 0; i < size; i++) {
			keys[i] = (String)NetMapp.parseArgs(out.packet, buf, String.class, (short) 0);
			values[i] = (double)NetMapp.parseArgs(out.packet, buf, Double.TYPE, (short) 0);
			modifiers[i] = (short)NetMapp.parseArgs(out.packet, buf, Short.TYPE, (short) 0);
			most[i] = new long[modifiers[i]];
			least[i] = new long[modifiers[i]];
			modifier[i] = new double[modifiers[i]];
			operation[i] = new byte[modifiers[i]];
			for(int ii = 0; ii < modifiers[i]; ii++) {
				most[i][ii] = (long)NetMapp.parseArgs(out.packet, buf, Long.TYPE, (short) 0);
				least[i][ii] = (long)NetMapp.parseArgs(out.packet, buf, Long.TYPE, (short) 0);
				modifier[i][ii] = (double)NetMapp.parseArgs(out.packet, buf, Double.TYPE, (short) 0);
				operation[i][ii] = (byte)NetMapp.parseArgs(out.packet, buf, Byte.TYPE, (short) 0);
			}
		}
		
		out.values.add(keys);
		desc.append("StringArray[").append(keys.length).append("], ");
		out.values.add(values);
		desc.append("DoubleArray[").append(values.length).append("], ");
		out.values.add(modifiers);
		desc.append("ShortArray[").append(modifiers.length).append("], ");
		out.values.add(most);
		desc.append("LongArrayArray[").append(most.length).append("][], ");
		out.values.add(least);
		desc.append("LongArrayArray[").append(least.length).append("][], ");
		out.values.add(modifier);
		desc.append("DoubleArrayArray[").append(modifier.length).append("][], ");
		out.values.add(operation);
		desc.append("ByteArrayArray[").append(operation.length).append("][], ");
	}

}
