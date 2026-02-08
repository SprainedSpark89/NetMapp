package io.github.SprainedSpark89.netmapp.version.base;

public enum PacketType {
	// c0.0.15a base stuff
	timeOut, // might be the blank new class thing, it's just like unused, just confusing
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
	userPerms
}
