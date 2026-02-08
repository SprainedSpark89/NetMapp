package io.github.SprainedSpark89.netmapp.version.java.classic;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.JavaVersion;
import io.github.SprainedSpark89.netmapp.version.java.classic.c15.c0_0_15a;
import io.github.SprainedSpark89.netmapp.version.java.classic.c16.c0_0_16a;
import io.github.SprainedSpark89.netmapp.version.java.classic.c17.c0_0_17a;
import io.github.SprainedSpark89.netmapp.version.java.classic.c19.c0_0_19a;
import io.github.SprainedSpark89.netmapp.version.java.classic.c20.c0_0_20a;
import io.github.SprainedSpark89.netmapp.version.java.classic.c30.c0_30;

public class ClassicVersion extends JavaVersion {
	public ClassicVersion(Versions ver) {
		super(ver);
		this.networkType = "classic";
	}
	
	public void registerVersions() {
		instance.registerVersion(new c0_0_15a(instance));
		instance.registerVersion(new c0_0_16a(instance));
		instance.registerVersion(new c0_0_17a(instance));
		// c0.0.18a is the same as c0.0.17a
		instance.registerVersion(new c0_0_19a(instance));
		instance.registerVersion(new c0_0_20a(instance)); // this is c0.0.20a-c0.27
		instance.registerVersion(new c0_30(instance)); // c0.28 to c0.30-renew
	}
}
