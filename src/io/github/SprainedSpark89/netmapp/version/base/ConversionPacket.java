package io.github.SprainedSpark89.netmapp.version.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Wasteful, yes, useful, for advanced things, yes
 * likely ever going to be used, no.
 */
public class ConversionPacket {
	public Packet packet;
	public List<LeftOverEntry> leftOvers = new ArrayList<LeftOverEntry>();
	public List<Packet> steps = new ArrayList<Packet>();
	
	
	public LeftOverEntry makeLeftOver(Class clazz, Object object, String string, Versions version) {
		return new LeftOverEntry(clazz, object, string, version);
	}
}

class LeftOverEntry {
	public Class clazz;
	public Object value;
	public String leftOverDesc;
	public Versions source;
	
	public LeftOverEntry(Class clazz, Object value, String desc, Versions ver) {
		this.clazz = clazz;
		this.value = value;
		this.leftOverDesc = desc;
		this.source = ver;
	}
}
