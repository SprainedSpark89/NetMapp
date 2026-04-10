package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w17a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketServerEncryption extends Packet {

	public PacketServerEncryption(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(String.class);
		this.args.add(byte[].class);
		
		this.argsDesc.add("Server Key"); // making this - will bypass
		/*
		 * or it's check session, server id being a hash of Server Key as a non utf string of bytes combined with secret and public keys encoded, and it all being read byte by byte into a MessageDigest updating each time until it's all read and then digests it
		 */
		this.argsDesc.add("Encoded Public Key");
		
		this.packetID = 253;
		this.packetType = PacketType.serverEncryption;
	}

}
