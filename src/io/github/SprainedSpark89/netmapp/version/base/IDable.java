package io.github.SprainedSpark89.netmapp.version.base;

public class IDable {
	public int numID;
	public String stringID;
	public String getOrigin() {
		return stringID.split(":")[0];
	}
	
	public String getName() {
		return stringID.split(":")[1];
	}
}
