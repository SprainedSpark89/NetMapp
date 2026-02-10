package io.github.SprainedSpark89.netmapp.version.java.alpha.a106;

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
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01.PacketPlayerMoveLook;

public class a1_0_6 extends AlphaVersion {

	public a1_0_6(Versions ver) {
		super(ver);
		// TODO Auto-generated constructor stub
		this.version = "a1.0.6";
		this.protocolNumber = 10;
		
		Packet p;
		
		p = new PacketHandshake(new ArrayList<Class<?>>(), new ArrayList<String>()); // 0
		this.packetList.put(p, p.packetType);
		
		p = new PacketPlayerMoveLook(new ArrayList<Class<?>>(), new ArrayList<String>()); // 1
		this.packetList.put(p, p.packetType);
		
		p = new PacketNamedEntitySpawn(new ArrayList<Class<?>>(), new ArrayList<String>()); // 2
		this.packetList.put(p, p.packetType);
		
		p = new PacketRemoveEntity(new ArrayList<Class<?>>(), new ArrayList<String>()); // 3
		this.packetList.put(p, p.packetType);
		
		p = new PacketPreChunk(new ArrayList<Class<?>>(), new ArrayList<String>()); // 9
		this.packetList.put(p, p.packetType);
		
		p = new PacketMapChunk(new ArrayList<Class<?>>(), new ArrayList<String>()); // 10
		this.packetList.put(p, p.packetType);
		
		p = new PacketMultiBlockChange(new ArrayList<Class<?>>(), new ArrayList<String>()); // 11
		this.packetList.put(p, p.packetType);
		
		p = new PacketBlockChange(new ArrayList<Class<?>>(), new ArrayList<String>()); // 12
		this.packetList.put(p, p.packetType);
		
		p = new PacketDig(new ArrayList<Class<?>>(), new ArrayList<String>()); // 50
		this.packetList.put(p, p.packetType);
		
		p = new PacketPlace(new ArrayList<Class<?>>(), new ArrayList<String>()); // 51
		this.packetList.put(p, p.packetType);
		
		p = new PacketHeldSwitch(new ArrayList<Class<?>>(), new ArrayList<String>()); // 52
		this.packetList.put(p, p.packetType);
		
		p = new PacketRelEntityMoveLook(new ArrayList<Class<?>>(), new ArrayList<String>()); // 100
		this.packetList.put(p, p.packetType);
		
		p = new PacketRelEntityMove(new ArrayList<Class<?>>(), new ArrayList<String>()); // 101
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityLook(new ArrayList<Class<?>>(), new ArrayList<String>()); // 102, the one we don't question
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntity(new ArrayList<Class<?>>(), new ArrayList<String>()); // 103
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityTP(new ArrayList<Class<?>>(), new ArrayList<String>()); // 104
		this.packetList.put(p, p.packetType);
		
		p = new PacketKeepAlive(new ArrayList<Class<?>>(), new ArrayList<String>()); // 254
		this.packetList.put(p, p.packetType);
		
		p = new PacketKickDisconnect(new ArrayList<Class<?>>(), new ArrayList<String>()); // 255
		this.packetList.put(p, p.packetType);
	}

}
