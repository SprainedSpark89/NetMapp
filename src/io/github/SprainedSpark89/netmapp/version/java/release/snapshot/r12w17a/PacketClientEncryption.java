package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w17a;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;

public class PacketClientEncryption extends Packet {

	public PacketClientEncryption(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(byte[].class);
		
		// please note that documentation will likely only valid for 12w17a, unless packet structure changes,
		// this will not change or list other versions
		this.argsDesc.add("Public Key and Encoded Secret Key"); // value is:
		/*
		 * Cipher of instance of key algorithm, then init cipher 1, then key, then do final data
		 */
		
		this.packetID = 252;
		this.packetType = PacketType.clientEncryption;
	}

}
