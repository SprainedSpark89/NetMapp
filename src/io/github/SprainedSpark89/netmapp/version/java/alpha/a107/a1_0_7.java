package io.github.SprainedSpark89.netmapp.version.java.alpha.a107;

import java.util.ArrayList;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.alpha.AlphaVersion;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105.PacketHandshake;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105.PacketKickDisconnect;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105.PacketMapChunk;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01.PacketBlockChange;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01.PacketDig;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01.PacketMultiBlockChange;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketEntity;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketEntityLook;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketEntityTP;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketHeldSwitch;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketKeepAlive;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketNamedEntitySpawn;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketPlace;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketPreChunk;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketRelEntityMove;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketRelEntityMoveLook;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketRemoveEntity;

public class a1_0_7 extends AlphaVersion {

	public a1_0_7(Versions ver) {
		super(ver);
		// TODO Auto-generated constructor stub
		this.version = "a1.0.7";
		this.protocolNumber = 10;
		
		Packet p;
		
		p = new PacketKeepAlive(new ArrayList<Class<?>>(), new ArrayList<String>()); // 0
		p.packetID = 0;
		this.packetList.put(p, p.packetType);
		
		p = new PacketHandshake(new ArrayList<Class<?>>(), new ArrayList<String>()); // 1
		p.packetID = 1;
		this.packetList.put(p, p.packetType);
		
		p = new PacketFlying(new ArrayList<Class<?>>(), new ArrayList<String>()); // 10
		this.packetList.put(p, p.packetType);
		
		p = new PacketPlayerPos(new ArrayList<Class<?>>(), new ArrayList<String>()); // 11
		this.packetList.put(p, p.packetType);
		
		p = new PacketPlayerLook(new ArrayList<Class<?>>(), new ArrayList<String>()); // 12
		this.packetList.put(p, p.packetType);
		
		p = new PacketPlayerMoveLook(new ArrayList<Class<?>>(), new ArrayList<String>()); // 13
		this.packetList.put(p, p.packetType);
		
		p = new PacketDig(new ArrayList<Class<?>>(), new ArrayList<String>()); // 14
		p.packetID = 14;
		this.packetList.put(p, p.packetType);
		
		p = new PacketPlace(new ArrayList<Class<?>>(), new ArrayList<String>()); // 15
		p.packetID = 15;
		this.packetList.put(p, p.packetType);
		
		p = new PacketHeldSwitch(new ArrayList<Class<?>>(), new ArrayList<String>()); // 16
		p.packetID = 16;
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketEntity(new ArrayList<Class<?>>(), new ArrayList<String>()); // 20
		p.packetID = 20;
		this.packetList.put(p, p.packetType);
		
		p = new PacketRelEntityMove(new ArrayList<Class<?>>(), new ArrayList<String>()); // 21
		p.packetID = 21;
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityLook(new ArrayList<Class<?>>(), new ArrayList<String>()); // 22
		p.packetID = 22;
		this.packetList.put(p, p.packetType);
		
		p = new PacketRelEntityMoveLook(new ArrayList<Class<?>>(), new ArrayList<String>()); // 23
		p.packetID = 23;
		this.packetList.put(p, p.packetType);
		
		p = new PacketNamedEntitySpawn(new ArrayList<Class<?>>(), new ArrayList<String>()); // 24
		p.packetID = 24;
		this.packetList.put(p, p.packetType);
		
		p = new PacketRemoveEntity(new ArrayList<Class<?>>(), new ArrayList<String>()); // 25
		p.packetID = 25;
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityTP(new ArrayList<Class<?>>(), new ArrayList<String>()); // 26
		p.packetID = 26;
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketPreChunk(new ArrayList<Class<?>>(), new ArrayList<String>()); // 50
		p.packetID = 50;
		this.packetList.put(p, p.packetType);
		
		p = new PacketMapChunk(new ArrayList<Class<?>>(), new ArrayList<String>()); // 51
		p.packetID = 51;
		this.packetList.put(p, p.packetType);
		
		p = new PacketMultiBlockChange(new ArrayList<Class<?>>(), new ArrayList<String>()); // 52
		p.packetID = 52;
		this.packetList.put(p, p.packetType);
		
		p = new PacketBlockChange(new ArrayList<Class<?>>(), new ArrayList<String>()); // 53
		p.packetID = 53;
		this.packetList.put(p, p.packetType);
		
		

		p = new PacketKickDisconnect(new ArrayList<Class<?>>(), new ArrayList<String>()); // 255
		this.packetList.put(p, p.packetType);
	}

}
