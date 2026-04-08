package io.github.SprainedSpark89.netmapp.version.java.beta.b17;

import java.util.ArrayList;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1010.PacketChat;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1010.PacketCollect;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1013.PacketEntityLook;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1015.PacketAnimate;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1015.PacketPlayerMoveLook;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1015.PacketPlayerPos;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1016.PacketHandshake;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1017.PacketTime;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105.PacketKickDisconnect;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105.PacketMapChunk;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01.PacketBlockChange;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01.PacketDig;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01.PacketMultiBlockChange;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketEntity;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketEntityTP;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketKeepAlive;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketNamedEntitySpawn;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketPreChunk;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketRelEntityMove;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketRelEntityMoveLook;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketRemoveEntity;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a107.PacketFlying;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a107.PacketPlayerLook;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a110.PacketSetSpawn;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a122.PacketEntityMount;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a122.PacketEntityVelocity;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a123.PacketEntityClick;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a123.PacketEntityTrigger;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a123_05.PacketExplosion;
import io.github.SprainedSpark89.netmapp.version.java.beta.BetaVersion;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.PacketCloseInv;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.PacketCurrentSlot;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.PacketHealth;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.PacketInvContents;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.PacketInvData;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.PacketInvVerify;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.PacketOpenInv;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.PacketSignData;
import io.github.SprainedSpark89.netmapp.version.java.beta.b12.PacketItemSpawn;
import io.github.SprainedSpark89.netmapp.version.java.beta.b12.PacketPaintingSpawn;
import io.github.SprainedSpark89.netmapp.version.java.beta.b12.PacketPlace;
import io.github.SprainedSpark89.netmapp.version.java.beta.b12.PacketPlayerActionChange;
import io.github.SprainedSpark89.netmapp.version.java.beta.b12.PacketSetSlot;
import io.github.SprainedSpark89.netmapp.version.java.beta.b12.PacketSlotContents;
import io.github.SprainedSpark89.netmapp.version.java.beta.b12.PacketTriggerBlockEvent;
import io.github.SprainedSpark89.netmapp.version.java.beta.b13.PacketAddEntity;
import io.github.SprainedSpark89.netmapp.version.java.beta.b13.PacketEntityDataSync;
import io.github.SprainedSpark89.netmapp.version.java.beta.b13.PacketPlayerInput;
import io.github.SprainedSpark89.netmapp.version.java.beta.b13.PacketSleep;
import io.github.SprainedSpark89.netmapp.version.java.beta.b14.PacketNotification;
import io.github.SprainedSpark89.netmapp.version.java.beta.b15.PacketForceAddEntity;
import io.github.SprainedSpark89.netmapp.version.java.beta.b15.PacketInvClick;
import io.github.SprainedSpark89.netmapp.version.java.beta.b15.PacketLogin;
import io.github.SprainedSpark89.netmapp.version.java.beta.b15.PacketStat;
import io.github.SprainedSpark89.netmapp.version.java.beta.preview.b16_preview.PacketMapData;
import io.github.SprainedSpark89.netmapp.version.java.beta.preview.b16_preview.PacketRespawn;
import io.github.SprainedSpark89.netmapp.version.java.beta.test_build.b16_tb3.PacketBlockUpdate;
import io.github.SprainedSpark89.netmapp.version.java.beta.test_build.b16_tb3.PacketVehicleSpawn;

public class b1_7 extends BetaVersion {

	public b1_7(Versions ver) {
		super(ver);
		this.version = "b1.7";
		this.protocolNumber = 14;
		
		Packet p;
		
		p = new PacketKeepAlive(new ArrayList<Class<?>>(), new ArrayList<String>()); // 0
		p.packetID = 0;
		this.packetList.put(p, p.packetType);
		
		p = new PacketLogin(new ArrayList<Class<?>>(), new ArrayList<String>()); // 1
		this.packetList.put(p, p.packetType);
		
		p = new PacketHandshake(new ArrayList<Class<?>>(), new ArrayList<String>()); // 2
		this.packetList.put(p, p.packetType);
		
		p = new PacketChat(new ArrayList<Class<?>>(), new ArrayList<String>()); // 3
		this.packetList.put(p, p.packetType);
		
		p = new PacketTime(new ArrayList<Class<?>>(), new ArrayList<String>()); // 4
		this.packetList.put(p, p.packetType);
		
		p = new PacketSetSlot(new ArrayList<Class<?>>(), new ArrayList<String>()); // 5
		this.packetList.put(p, p.packetType);
		
		p = new PacketSetSpawn(new ArrayList<Class<?>>(), new ArrayList<String>()); // 6
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityClick(new ArrayList<Class<?>>(), new ArrayList<String>()); // 7
		this.packetList.put(p, p.packetType);
		
		p = new PacketHealth(new ArrayList<Class<?>>(), new ArrayList<String>()); // 8
		this.packetList.put(p, p.packetType);
		
		p = new PacketRespawn(new ArrayList<Class<?>>(), new ArrayList<String>()); // 9
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
		this.packetList.put(p, p.packetType);
		
		p = new PacketCurrentSlot(new ArrayList<Class<?>>(), new ArrayList<String>()); // 16
		this.packetList.put(p, p.packetType);
		
		p = new PacketSleep(new ArrayList<Class<?>>(), new ArrayList<String>()); // 17
		this.packetList.put(p, p.packetType);
		
		p = new PacketAnimate(new ArrayList<Class<?>>(), new ArrayList<String>()); // 18
		this.packetList.put(p, p.packetType);
		
		p = new PacketPlayerActionChange(new ArrayList<Class<?>>(), new ArrayList<String>()); // 19
		this.packetList.put(p, p.packetType);
		
		p = new PacketNamedEntitySpawn(new ArrayList<Class<?>>(), new ArrayList<String>()); // 20
		p.packetID = 20;
		this.packetList.put(p, p.packetType);
		
		p = new PacketItemSpawn(new ArrayList<Class<?>>(), new ArrayList<String>()); // 21
		this.packetList.put(p, p.packetType);
		
		p = new PacketCollect(new ArrayList<Class<?>>(), new ArrayList<String>()); // 22
		this.packetList.put(p, p.packetType);
		
		p = new PacketVehicleSpawn(new ArrayList<Class<?>>(), new ArrayList<String>()); // 23
		this.packetList.put(p, p.packetType);
		
		p = new PacketAddEntity(new ArrayList<Class<?>>(), new ArrayList<String>()); // 24
		this.packetList.put(p, p.packetType);
		
		p = new PacketPaintingSpawn(new ArrayList<Class<?>>(), new ArrayList<String>()); // 25
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketPlayerInput(new ArrayList<Class<?>>(), new ArrayList<String>()); // 27
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityVelocity(new ArrayList<Class<?>>(), new ArrayList<String>()); // 28
		this.packetList.put(p, p.packetType);
		
		p = new PacketRemoveEntity(new ArrayList<Class<?>>(), new ArrayList<String>()); // 29
		p.packetID = 29;
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntity(new ArrayList<Class<?>>(), new ArrayList<String>()); // 30
		p.packetID = 30;
		this.packetList.put(p, p.packetType);
		
		p = new PacketRelEntityMove(new ArrayList<Class<?>>(), new ArrayList<String>()); // 31
		p.packetID = 31;
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityLook(new ArrayList<Class<?>>(), new ArrayList<String>()); // 32
		p.packetID = 32;
		this.packetList.put(p, p.packetType);
		
		p = new PacketRelEntityMoveLook(new ArrayList<Class<?>>(), new ArrayList<String>()); // 33
		p.packetID = 33;
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityTP(new ArrayList<Class<?>>(), new ArrayList<String>()); // 34
		p.packetID = 34;
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketEntityTrigger(new ArrayList<Class<?>>(), new ArrayList<String>()); // 38
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityMount(new ArrayList<Class<?>>(), new ArrayList<String>()); // 39
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityDataSync(new ArrayList<Class<?>>(), new ArrayList<String>()); // 40
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
		
		p = new PacketTriggerBlockEvent(new ArrayList<Class<?>>(), new ArrayList<String>()); // 54
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketExplosion(new ArrayList<Class<?>>(), new ArrayList<String>()); // 60
		this.packetList.put(p, p.packetType);
		
		p = new PacketBlockUpdate(new ArrayList<Class<?>>(), new ArrayList<String>()); // 61
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketNotification(new ArrayList<Class<?>>(), new ArrayList<String>()); // 70
		this.packetList.put(p, p.packetType);
		
		p = new PacketForceAddEntity(new ArrayList<Class<?>>(), new ArrayList<String>()); // 71
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketOpenInv(new ArrayList<Class<?>>(), new ArrayList<String>()); // 100
		this.packetList.put(p, p.packetType);
		
		p = new PacketCloseInv(new ArrayList<Class<?>>(), new ArrayList<String>()); // 101
		this.packetList.put(p, p.packetType);
		
		p = new PacketInvClick(new ArrayList<Class<?>>(), new ArrayList<String>()); // 102
		this.packetList.put(p, p.packetType);
		
		p = new PacketSlotContents(new ArrayList<Class<?>>(), new ArrayList<String>()); // 103
		this.packetList.put(p, p.packetType);
		
		p = new PacketInvContents(new ArrayList<Class<?>>(), new ArrayList<String>()); // 104
		this.packetList.put(p, p.packetType);
		
		p = new PacketInvData(new ArrayList<Class<?>>(), new ArrayList<String>()); // 105
		this.packetList.put(p, p.packetType);
		
		p = new PacketInvVerify(new ArrayList<Class<?>>(), new ArrayList<String>()); // 106
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketSignData(new ArrayList<Class<?>>(), new ArrayList<String>()); // 130
		this.packetList.put(p, p.packetType);
		
		p = new PacketMapData(new ArrayList<Class<?>>(), new ArrayList<String>()); // 131
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketStat(new ArrayList<Class<?>>(), new ArrayList<String>()); // 200
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketKickDisconnect(new ArrayList<Class<?>>(), new ArrayList<String>()); // 255
		this.packetList.put(p, p.packetType);
	}

}
