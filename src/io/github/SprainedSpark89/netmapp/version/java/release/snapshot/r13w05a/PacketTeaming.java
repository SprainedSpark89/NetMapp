package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w05a;

import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketTeaming extends Packet {

	public PacketTeaming(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		this.args.add(String.class);
		this.args.add(Byte.TYPE);
		this.args.add(String.class);
		this.args.add(String.class);
		this.args.add(String.class);
		this.args.add(Boolean.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(String[].class);
		
		this.argsDesc.add("Team Name");
		this.argsDesc.add("Operation");
		this.argsDesc.add("Team Display Name");
		this.argsDesc.add("Team Prefix");
		this.argsDesc.add("Team Suffix");
		this.argsDesc.add("Friendly Fire");
		this.argsDesc.add("Member Amount");
		this.argsDesc.add("Member Names");
		
		this.packetID = 209;
		this.packetType = PacketType.teaming;
		this.read = new SpecialRead(true, 2);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		byte action = (byte)out.values.get(2);
		String displayName = null, prefix = null, suffix = null;
		boolean friendlyFire = false;
		if(action == 0 || action == 2) {
			displayName = (String)NetMapp.parseArgs(out.packet, buf, String.class, (short) 0);
			prefix = (String)NetMapp.parseArgs(out.packet, buf, String.class, (short) 0);
			suffix = (String)NetMapp.parseArgs(out.packet, buf, String.class, (short) 0);
			friendlyFire = (boolean)NetMapp.parseArgs(out.packet, buf, Boolean.TYPE, (short) 0);
		}
		short memberAmount = 0;
		String[] members = null;
		if(action == 0 || action == 3 || action == 4) {
			memberAmount = (short)NetMapp.parseArgs(out.packet, buf, Short.TYPE, (short) 0);
			members = new String[memberAmount];
			for(int i = 0; i < memberAmount; i++) {
				members[i] = (String)NetMapp.parseArgs(out.packet, buf, String.class, (short) 0);
			}
		}
		
		out.values.add(action);
		desc.append("Byte: ").append(action).append(", ");
		
		out.values.add(displayName);
		desc.append("String: \"").append(displayName).append("\", ");
		
		out.values.add(prefix);
		desc.append("String: \"").append(prefix).append("\", ");
		
		out.values.add(suffix);
		desc.append("String: \"").append(suffix).append("\", ");
		
		out.values.add(friendlyFire);
		desc.append("Boolean: ").append(friendlyFire).append(", ");
		
		out.values.add(memberAmount);
		desc.append("Short: ").append(memberAmount).append(", ");
		
		out.values.add(members);
		desc.append("StringArray[").append(memberAmount).append("], ");
		
	}

}
