package io.github.SprainedSpark89.netmapp.version.base;

import java.nio.ByteBuffer;
import java.util.*;

public abstract class Packet {
	public List<Class<?>> args = new ArrayList<Class<?>>();
	public List<String> argsDesc = new ArrayList<String>();
	public PacketType packetType;
	public int packetID;
	public SpecialRead read;
	
	public Packet(List<Class<?>> inputs, List<String> descriptions) {
		args.addAll(inputs);
		argsDesc.addAll(descriptions);
	}
	
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		
	}
}
