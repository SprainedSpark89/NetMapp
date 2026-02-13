package io.github.SprainedSpark89.netmapp.version.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.SprainedSpark89.netmapp.version.java.alpha.AlphaVersion;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.a1_0_6;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a107.a1_0_7;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a109.a1_0_9;
import io.github.SprainedSpark89.netmapp.version.java.classic.ClassicVersion;

public class Utils {
	
	public static List<Versions> versionList = new ArrayList<Versions>();
	
	
	/**
	 * Includes PacketId in the length
	 */
	
	public static int getPacketLength(Packet packet, Versions ver) {
		if(ver instanceof ClassicVersion) {
			int pCS = 1;
			for(Class<?> clazz : packet.args) {
				
				if(clazz == Long.TYPE) {
					pCS += Long.BYTES;
				} else if(clazz == Short.TYPE) {
					pCS += Short.BYTES;
				} else if(clazz == Byte.TYPE) {
					pCS += Byte.BYTES;
				} else if(clazz == Double.TYPE) {
					pCS += Double.BYTES;
				} else if(clazz == Float.TYPE) {
					pCS += Float.BYTES;
				} else if(clazz == byte[].class) {
					pCS += 1024;
				} else if(clazz == String.class) {
					pCS += 64;
				} else {
					System.out.println("Unknown Length of:" + clazz.getSimpleName());
				}
			}
			return pCS;
		}
		return -1;
	}
	
	public static Packet getPacketFromID(byte id, Versions ver) {
		
		for (Packet packet : ver.packetList.keySet()) {
			if ((id & 0xFF) == (packet.packetID & 0xFF)) {
				return packet;
			}
		}
		return null;
	}
	
	public static List<Versions> getAllVersions() {
		return versionList;
	}
	
	
	/**
	 * baseVersion is just to limit the search range, you can use Versions if you really need to
	 */
	public static Versions getVersionFromProtocolNumber(Versions baseVersion, int protocol) {
		if(baseVersion instanceof AlphaVersion && protocol == 10) { // yeah, i don't feel like dealing with some things
			return new a1_0_9(Versions.instance);
		}
		
		//List<Versions> out = new ArrayList<Versions>();
		for(Versions ver : versionList) {
			if(ver.networkType.equals(baseVersion.networkType) && ver.protocolNumber == protocol) {
				return ver;
			}
		}
		return null;
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
