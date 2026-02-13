package io.github.SprainedSpark89.netmapp.version.base;

import java.util.*;

import io.github.SprainedSpark89.netmapp.version.java.JavaVersion;

public class Versions {
	public String version;
	public String protocol;
	public long defaultPort;
	public Map<Packet, PacketType> packetList = new HashMap<Packet, PacketType>();
	public String networkType;
	public int protocolNumber;
	public static Versions instance;
	public List<IDable> blocks = new ArrayList<IDable>();
	public List<IDable> items = new ArrayList<IDable>();
	
	public Versions(Versions ver) {
		this.instance = this;
	}
	
	public void registerVersions() {
		JavaVersion javaVersion = new JavaVersion(instance);
		javaVersion.registerVersions();
	}
	
	public void registerVersion(Versions ver) {
		Utils.versionList.add(ver);
	}
}
