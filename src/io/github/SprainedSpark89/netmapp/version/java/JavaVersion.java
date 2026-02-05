package io.github.SprainedSpark89.netmapp.version.java;

import io.github.SprainedSpark89.netmapp.version.base.Versions;

public abstract class JavaVersion extends Versions {
	
	public JavaVersion(Versions ver) {
		super(ver);
		this.protocol = "tcp";
		this.defaultPort = 25565;
	}
}
