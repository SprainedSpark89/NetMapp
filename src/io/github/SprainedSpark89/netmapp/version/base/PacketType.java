package io.github.SprainedSpark89.netmapp.version.base;

public enum PacketType {
	// c0.0.15a base stuff
	blank, // might be the blank new class thing, it's just like unused, just confusing
	login,
	startWorldData,
	worldData,
	worldDataEnd,
	blockUpdate,
	entityJoin,
	entityMove,
	entityRemove,
	setBlock,
	
	// c0.0.16a
	entitySetPos,
	entityMoveRot,
	entityRot,
	chat,
	kick,
	
	// c0.30
	userPerms,
	
	// a1.0.5_01
	multiBlockUpdate,
	dig,
	
	// a1.0.6
	namedEntitySpawn,
	chunkLoad,
	blockPlace,
	handSwap,
	entity,
	entityRelMoveRot,
	entityRelMove,
	keepAlive,
	
	// a1.0.7
	flying,
	playerPos,
	playerLook,
	
	// a1.0.9
	itemDrop,
	
	// a1.0.10
	itemInvAdd,
	entityCollect,
	
	// a1.0.15
	handshake,
	animate,
	vehicleSpawn,
	
	// a1.0.17
	time,
	entityAdd,
	
	// a1.1.0
	setInventory,
	setSpawn,
	tileEntityData,
	
	// a1.2.2
	entityClick,
	entityVel,
	entitySit,
	
	// a1.2.3
	health,
	respawn,
	entityTrigger,
	
	// a1.2.3_05
	explosion,
	
	// b1.0
	openInv,
	closeInv,
	invClick,
	slotContents,
	setInvData,
	invCheck,
	signData,
	
	// b1.2
	actionChange,
	spawnPainting,
	entityDataSync,
	blockEventTrigger,
	
	// b1.3
	playerInput,
	sleep,
	
	// b1.4
	notification,
	
	// b1.5
	forceAddEntity,
	stat,
	
	// b1.6-preview
	mapData,
	
	// b1.6-tb3
	updateBlock,
	
	// b1.8-pre1
	creativeSlot,
	effectRemove,
	effectAdd,
	serverListEntry,
	playerListEntry,
	executionPoints,
	
	// b1.8-pre2
	executionPointOrbAdd,
	
	// b1.9-pre4
	menuClick
}
