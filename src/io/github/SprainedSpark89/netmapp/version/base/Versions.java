package io.github.SprainedSpark89.netmapp.version.base;

import java.util.*;

public abstract class Versions {
	public String version;
	public String protocol;
	public long defaultPort;
	public Map<Packet, PacketType> packetList = new HashMap<Packet, PacketType>();
	public String networkType;
	public int protocolNumber;
	
	public Versions(Versions ver) {
		
	}
}
