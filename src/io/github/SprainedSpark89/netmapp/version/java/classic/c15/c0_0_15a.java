package io.github.SprainedSpark89.netmapp.version.java.classic.c15;

import java.util.ArrayList;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.classic.ClassicVersion;

public class c0_0_15a extends ClassicVersion {

	public c0_0_15a(Versions ver) {
		super(ver);
		this.version = "c0.0.15a";
		this.defaultPort = 5565;
		this.protocolNumber = (int)Float.NaN; // no protocol number
		
		Packet p;
		
		p = new PacketBlank(new ArrayList<Class<?>>(), new ArrayList<String>()); // Packet 1, just unknown use for now
		this.packetList.put(p, p.packetType);

		p = new PacketBlockUpdate(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);

		p = new PacketDisconnect(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);

		p = new PacketEntityMove(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);

		p = new PacketLevelData(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);

		p = new PacketLevelEnd(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);

		p = new PacketLevelInit(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);

		p = new PacketLogin(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);

		p = new PacketPlayerAdd(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);

		p = new PacketSetBlock(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);


	}

}