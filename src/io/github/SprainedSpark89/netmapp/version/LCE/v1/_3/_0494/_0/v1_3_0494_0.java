package io.github.SprainedSpark89.netmapp.version.LCE.v1._3._0494._0;

import java.util.ArrayList;

import io.github.SprainedSpark89.netmapp.version.LCE.LCEVersion;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.Versions;

public class v1_3_0494_0 extends LCEVersion {

	public v1_3_0494_0(Versions ver) {
		super(ver);
		// TODO Auto-generated constructor stub
		this.version = "v1.3.0494.0";
		
		Packet p;
		
		// 0(KeepAlivePacket), KeepAlivePacket
		p = new PacketKeepAlive(new ArrayList<Class<?>>(), new ArrayList<String>());
		this.packetList.put(p, p.packetType);
		// 1(LoginPacket), LoginPacket
		
		// 2(PreLoginPacket), PreLoginPacket
		// 3(ChatPacket), ChatPacket
		// 4(SetTimePacket), SetTimePacket
		// 5(SetEquippedItemPacket), SetEquippedItemPacket
		// 6(SetSpawnPositionPacket), SetSpawnPositionPacket
		// 7(InteractPacket), InteractPacket
		// 8(SetHealthPacket), SetHealthPacket
		// 9(RespawnPacket), RespawnPacket

		// 10(MovePlayerPacket), MovePlayerPacket	
		// 11(MovePlayerPacket::Pos), MovePlayerPacket::Pos
		// 12(MovePlayerPacket::Rot), MovePlayerPacket::Rot
		// 13(MovePlayerPacket::PosRot), MovePlayerPacket::PosRot

		// 14(PlayerActionPacket), PlayerActionPacket
		// 15(UseItemPacket), UseItemPacket
		// 16(SetCarriedItemPacket), SetCarriedItemPacket
		// 17(EntityActionAtPositionPacket), EntityActionAtPositionPacket
		// 18(AnimatePacket), AnimatePacket
		// 19(PlayerCommandPacket), PlayerCommandPacket

		// 20(AddPlayerPacket), AddPlayerPacket
		// 22(TakeItemEntityPacket), TakeItemEntityPacket
		// 23(AddEntityPacket), AddEntityPacket
		// 24(AddMobPacket), AddMobPacket
		// 25(AddPaintingPacket), AddPaintingPacket
		// 26(AddExperienceOrbPacket), AddExperienceOrbPacket
		// 28(SetEntityMotionPacket), SetEntityMotionPacket
		// 29(RemoveEntitiesPacket), RemoveEntitiesPacket

		// 30(MoveEntityPacket), MoveEntityPacket
		// 31(MoveEntityPacket::Pos), MoveEntityPacket::Pos
		// 32(MoveEntityPacket::Rot), MoveEntityPacket::Rot
		// 33(MoveEntityPacket::PosRot), MoveEntityPacket::PosRot
		// 34(TeleportEntityPacket), TeleportEntityPacket
		// 35(RotateHeadPacket), RotateHeadPacket
		// 38(EntityEventPacket), EntityEventPacket
		// 39(SetRidingPacket), SetRidingPacket
		// 40(SetEntityDataPacket), SetEntityDataPacket
		// 41(UpdateMobEffectPacket), UpdateMobEffectPacket
		// 42(RemoveMobEffectPacket), RemoveMobEffectPacket
		// 43(SetExperiencePacket), SetExperiencePacket
		// 50(ChunkVisibilityPacket), ChunkVisibilityPacket
		// 51(BlockRegionUpdatePacket), BlockRegionUpdatePacket
		// 52(ChunkTilesUpdatePacket), ChunkTilesUpdatePacket
		// 53(TileUpdatePacket), TileUpdatePacket
		// 54(TileEventPacket), TileEventPacket
		// 55(TileDestructionPacket), TileDestructionPacket

		// 60(ExplodePacket), ExplodePacket
		// 61(LevelEventPacket), LevelEventPacket
		// 62(LevelSoundPacket), LevelSoundPacket
		// 70(GameEventPacket), GameEventPacket
		// 71(AddGlobalEntityPacket), AddGlobalEntityPacket

		// 100(ContainerOpenPacket), ContainerOpenPacket
		// 101(ContainerClosePacket), ContainerClosePacket
		// 102(ContainerClickPacket), ContainerClickPacket
		// 103(ContainerSetSlotPacket), ContainerSetSlotPacket
		// 104(ContainerSetContentPacket), ContainerSetContentPacket
		// 105(ContainerSetDataPacket), ContainerSetDataPacket
		// 106(ContainerAckPacket), ContainerAckPacket
		// 107(SetCreativeModeSlotPacket), SetCreativeModeSlotPacket
		// 108(ContainerButtonClickPacket), ContainerButtonClickPacket

		// 130(SignUpdatePacket), SignUpdatePacket
		// 131(ComplexItemDataPacket), ComplexItemDataPacket
		// 132(TileEntityDataPacket), TileEntityDataPacket

		// 150(CraftItemPacket), CraftItemPacket
		// 151(TradeItemPacket), TradeItemPacket
		// 152(DebugOptionsPacket), DebugOptionsPacket
		// 153(ServerSettingsChangedPacket), ServerSettingsChangedPacket
		// 154(TexturePacket), TexturePacket
		// 155(ChunkVisibilityAreaPacket), ChunkVisibilityAreaPacket
		// 156(UpdateProgressPacket), UpdateProgressPacket
		// 157(TextureChangePacket), TextureChangePacket
		// 158(UpdateGameRuleProgressPacket), UpdateGameRuleProgressPacket
		// 159(KickPlayerPacket), KickPlayerPacket
		// 160(TextureAndGeometryPacket), TextureAndGeometryPacket
		// 161(TextureAndGeometryChangePacket), TextureAndGeometryChangePacket
		// 162(MoveEntityPacketSmall), MoveEntityPacketSmall
		// 163(MoveEntityPacketSmall::Pos), MoveEntityPacketSmall::Pos
		// 164( MoveEntityPacketSmall::Rot), MoveEntityPacketSmall::Rot
		// 165(MoveEntityPacketSmall::PosRot), MoveEntityPacketSmall::PosRot
		// 166(XZPacket), XZPacket
		// 167(GameCommandPacket), GameCommandPacket

		// 200(AwardStatPacket), AwardStatPacket
		// 201(PlayerInfoPacket), PlayerInfoPacket
		// 202(PlayerAbilitiesPacket), PlayerAbilitiesPacket
		// 205(ClientCommandPacket), ClientCommandPacket
		// 250(CustomPayloadPacket), CustomPayloadPacket
		// 254(GetInfoPacket), GetInfoPacket
		// 255(DisconnectPacket), DisconnectPacket

		
	}

}
