package io.github.SprainedSpark89.netmapp.version.java.classic.c16;

import java.util.ArrayList;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.classic.ClassicVersion;
import io.github.SprainedSpark89.netmapp.version.java.classic.c15.PacketBlank;
import io.github.SprainedSpark89.netmapp.version.java.classic.c15.PacketBlockUpdate;
import io.github.SprainedSpark89.netmapp.version.java.classic.c15.PacketDisconnect;
import io.github.SprainedSpark89.netmapp.version.java.classic.c15.PacketLevelData;
import io.github.SprainedSpark89.netmapp.version.java.classic.c15.PacketLevelEnd;
import io.github.SprainedSpark89.netmapp.version.java.classic.c15.PacketLevelInit;
import io.github.SprainedSpark89.netmapp.version.java.classic.c15.PacketPlayerAdd;
import io.github.SprainedSpark89.netmapp.version.java.classic.c15.PacketSetBlock;

public class c0_0_16a extends ClassicVersion {

	public c0_0_16a(Versions ver) {
		super(ver);
		// TODO Auto-generated constructor stub
		this.version = "c0.0.16a";
		this.protocolNumber = (byte)3;
		
		Packet p;
		
		p = new PacketLogin(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		
		p = new PacketBlank(new ArrayList<Class<?>>(), new ArrayList<String>()); // Packet 1, just unknown use for now
		this.packetList.put(p, p.packetType);

		p = new PacketLevelInit(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		
		p = new PacketLevelData(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		
		p = new PacketLevelEnd(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		
		p = new PacketBlockUpdate(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		
		p = new PacketSetBlock(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);

		p = new PacketPlayerAdd(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityTP(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityMoveRotate(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityMove(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityRotation(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		
		p = new PacketDisconnect(new ArrayList<Class<?>>(), new ArrayList<String>());
		p.packetID = 12;
		this.packetList.put(p, p.packetType);
		
		p = new PacketChat(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		
		p = new PacketKick(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
	}

}
