package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w21a;

import java.util.ArrayList;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1010.PacketChat;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1010.PacketCollect;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1013.PacketEntityLook;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1015.PacketAnimate;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1015.PacketPlayerMoveLook;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1015.PacketPlayerPos;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1017.PacketTime;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105.PacketKickDisconnect;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01.PacketBlockChange;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01.PacketDig;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketEntity;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketEntityTP;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.PacketNamedEntitySpawn;
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
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.PacketCloseInv;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.PacketCurrentSlot;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.PacketInvData;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.PacketInvVerify;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.PacketOpenInv;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.PacketSignData;
import io.github.SprainedSpark89.netmapp.version.java.beta.b12.PacketItemSpawn;
import io.github.SprainedSpark89.netmapp.version.java.beta.b12.PacketPaintingSpawn;
import io.github.SprainedSpark89.netmapp.version.java.beta.b12.PacketPlayerActionChange;
import io.github.SprainedSpark89.netmapp.version.java.beta.b12.PacketSetSlot;
import io.github.SprainedSpark89.netmapp.version.java.beta.b12.PacketTriggerBlockEvent;
import io.github.SprainedSpark89.netmapp.version.java.beta.b13.PacketEntityDataSync;
import io.github.SprainedSpark89.netmapp.version.java.beta.b13.PacketSleep;
import io.github.SprainedSpark89.netmapp.version.java.beta.b14.PacketNotification;
import io.github.SprainedSpark89.netmapp.version.java.beta.b15.PacketForceAddEntity;
import io.github.SprainedSpark89.netmapp.version.java.beta.b15.PacketStat;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre1.PacketEffectAdd;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre1.PacketEffectRemove;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre1.PacketHealth;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre1.PacketKeepAlive;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre1.PacketPlayerListEntry;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre1.PacketServerListEntry;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre2.PacketExecutionPointOrbAdd;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre2.PacketInvClick;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre2.PacketInvContents;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre2.PacketPlace;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre2.PacketSlotContents;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre4.PacketExecutionPoints;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre4.PacketMenuClick;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre5.PacketCreativeMenuSlot;
import io.github.SprainedSpark89.netmapp.version.java.beta.preview.b16_preview.PacketMapData;
import io.github.SprainedSpark89.netmapp.version.java.beta.test_build.b16_tb3.PacketBlockUpdate;
import io.github.SprainedSpark89.netmapp.version.java.beta.test_build.b16_tb3.PacketVehicleSpawn;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.ReleaseSnapshotVersion;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r11w49a.PacketModPluginDataTransfer;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w03a.PacketAddEntity;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w03a.PacketHeadAngles;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w06a.PacketTileEntityData;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w07a.PacketMapChunk;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w08a.PacketMultiBlockChange;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w08a.PacketRespawn;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w16a.PacketCommandSuggestion;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w17a.PacketClientEncryption;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w17a.PacketServerEncryption;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w18a.PacketClientSettings;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w18a.PacketHandshake;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w18a.PacketLogin;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w18a.PacketPerms;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w18a.PacketSound;

public class r12w21a extends ReleaseSnapshotVersion { // changed encryption again

	public r12w21a(Versions ver) {
		super(ver);
		this.version = "12w21a";
		this.protocolNumber = 33;
		
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
		
		p = new PacketExecutionPointOrbAdd(new ArrayList<Class<?>>(), new ArrayList<String>()); // 26
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
		
		p = new PacketHeadAngles(new ArrayList<Class<?>>(), new ArrayList<String>()); // 35
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketEntityTrigger(new ArrayList<Class<?>>(), new ArrayList<String>()); // 38
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityMount(new ArrayList<Class<?>>(), new ArrayList<String>()); // 39
		this.packetList.put(p, p.packetType);
		
		p = new PacketEntityDataSync(new ArrayList<Class<?>>(), new ArrayList<String>()); // 40
		this.packetList.put(p, p.packetType);
		
		p = new PacketEffectAdd(new ArrayList<Class<?>>(), new ArrayList<String>()); // 41
		this.packetList.put(p, p.packetType);
		
		p = new PacketEffectRemove(new ArrayList<Class<?>>(), new ArrayList<String>()); // 42
		this.packetList.put(p, p.packetType);
		
		p = new PacketExecutionPoints(new ArrayList<Class<?>>(), new ArrayList<String>()); // 43
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketMapChunk(new ArrayList<Class<?>>(), new ArrayList<String>()); // 51
		this.packetList.put(p, p.packetType);
		
		p = new PacketMultiBlockChange(new ArrayList<Class<?>>(), new ArrayList<String>()); // 52
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
		
		p = new PacketSound(new ArrayList<Class<?>>(), new ArrayList<String>()); // 62
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
		
		p = new PacketCreativeMenuSlot(new ArrayList<Class<?>>(), new ArrayList<String>()); // 107
		this.packetList.put(p, p.packetType);
		
		p = new PacketMenuClick(new ArrayList<Class<?>>(), new ArrayList<String>()); // 108
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketSignData(new ArrayList<Class<?>>(), new ArrayList<String>()); // 130
		this.packetList.put(p, p.packetType);
		
		p = new PacketMapData(new ArrayList<Class<?>>(), new ArrayList<String>()); // 131
		this.packetList.put(p, p.packetType);
		
		p = new PacketTileEntityData(new ArrayList<Class<?>>(), new ArrayList<String>()); // 132
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketStat(new ArrayList<Class<?>>(), new ArrayList<String>()); // 200
		this.packetList.put(p, p.packetType);
		
		p = new PacketPlayerListEntry(new ArrayList<Class<?>>(), new ArrayList<String>()); // 201
		this.packetList.put(p, p.packetType);
		
		p = new PacketPerms(new ArrayList<Class<?>>(), new ArrayList<String>()); // 202
		this.packetList.put(p, p.packetType);
		
		p = new PacketCommandSuggestion(new ArrayList<Class<?>>(), new ArrayList<String>()); // 203
		this.packetList.put(p, p.packetType);
		
		p = new PacketClientSettings(new ArrayList<Class<?>>(), new ArrayList<String>()); // 204
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketModPluginDataTransfer(new ArrayList<Class<?>>(), new ArrayList<String>()); // 250
		this.packetList.put(p, p.packetType);
		
		
		p = new PacketClientEncryption(new ArrayList<Class<?>>(), new ArrayList<String>()); // 252
		this.packetList.put(p, p.packetType);
		
		p = new PacketServerEncryption(new ArrayList<Class<?>>(), new ArrayList<String>()); // 253
		this.packetList.put(p, p.packetType);
		
		p = new PacketServerListEntry(new ArrayList<Class<?>>(), new ArrayList<String>()); // 254
		this.packetList.put(p, p.packetType);
		
		p = new PacketKickDisconnect(new ArrayList<Class<?>>(), new ArrayList<String>()); // 255
		this.packetList.put(p, p.packetType);
	}

}
