package io.github.SprainedSpark89.netmapp.version.java.alpha;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.JavaVersion;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105.a1_0_5;

public class AlphaVersion extends JavaVersion {

	public AlphaVersion(Versions ver) {
		super(ver);
		this.networkType = "alpha";
	}
	
	public void registerVersions() {
		instance.registerVersion(new a1_0_5(instance));
	}

}
