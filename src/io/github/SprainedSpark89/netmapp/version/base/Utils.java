package io.github.SprainedSpark89.netmapp.version.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
	
	public static List<Versions> versionList = new ArrayList<Versions>();
	
	public static Packet getPacketFromID(byte id, Versions ver) {
		
		for (Packet packet : ver.packetList.keySet()) {
			if (id == packet.packetID) {
				return packet;
			}
		}
		return null;
	}
	
	public static List<Versions> getAllVersions() {
		return versionList;
	}
	
	public static List<Versions> getTCPVersions() {
		List<Versions> out = new ArrayList<Versions>();
		for(Versions ver : versionList) {
			if(ver.protocol.toLowerCase().contentEquals("tcp")) {
				out.add(ver);
			}
		}
		return out;
	}
	
	public static List<Versions> getUDPVersions() {
		List<Versions> out = new ArrayList<Versions>();
		for(Versions ver : versionList) {
			if(ver.protocol.toLowerCase().contentEquals("udp")) {
				out.add(ver);
			}
		}
		return out;
	}
	
	public static List<Packet> getLoginPackets(List<Versions> vers) {
		List<Packet> out = new ArrayList<Packet>();
		for(Versions ver : vers) {
			for(Packet packet : ver.packetList.keySet()) {
				if(packet.packetType == PacketType.login) {
					out.add(packet);
				}
			}
		}
		return out;
	}
	
	public static Versions getVersionFromPacket(Packet packet) {
		for(Versions ver : versionList) {
			if(ver.packetList.keySet().contains(packet)) {
				return ver;
			}
		}
		return null;
	}
	
	public static <K, V> HashMap<V, K> invertMap(Map<K, V> map) {
	    HashMap<V, K> inverted = new HashMap<>();

	    for (Map.Entry<K, V> entry : map.entrySet()) {
	        inverted.put(entry.getValue(), entry.getKey());
	    }

	    return inverted;
	}

}
