package io.github.SprainedSpark89.netmapp.version.base;

import java.util.*;

public abstract class Packet {
	public List<Class> args = new ArrayList<Class>();
	public List<String> argsDesc = new ArrayList<String>();
	public PacketType packetType;
	
	public Packet(List<Class> inputs, List<String> descriptions) {
		args.addAll(inputs);
		argsDesc.addAll(descriptions);
		
	}
}
