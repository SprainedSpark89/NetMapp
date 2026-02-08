package io.github.SprainedSpark89.netmapp.version.java.alpha.a105;

import java.util.ArrayList;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.alpha.AlphaVersion;

public class a1_0_5 extends AlphaVersion {

	public a1_0_5(Versions ver) {
		super(ver);
		// TODO Auto-generated constructor stub
		this.version = "a1.0.5";
		this.protocolNumber = 10;
		
		Packet p;
		
		p = new PacketHandshake(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		
		p = new PacketPlayerMoveLook(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		
		p = new PacketMapChunk(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		
		p = new PacketKickDisconnect(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
	}

}
