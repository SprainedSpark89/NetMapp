package io.github.SprainedSpark89.netmapp.version.java.classic;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.JavaVersion;
import io.github.SprainedSpark89.netmapp.version.java.classic.c15.c0_0_15a;

public class ClassicVersion extends JavaVersion {
	public ClassicVersion(Versions ver) {
		super(ver);
		this.networkType = "classic";
	}
	
	public void registerVersions() {
		instance.registerVersion(new c0_0_15a(instance));
	}
}
