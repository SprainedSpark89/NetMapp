package io.github.SprainedSpark89.netmapp.version.java.classic;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.JavaVersion;

public abstract class ClassicVersion extends JavaVersion {
	public ClassicVersion(Versions ver) {
		super(ver);
		this.networkType = "classic";
	}
}
