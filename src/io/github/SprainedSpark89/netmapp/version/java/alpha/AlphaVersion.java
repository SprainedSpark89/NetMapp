package io.github.SprainedSpark89.netmapp.version.java.alpha;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.JavaVersion;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105.a1_0_5;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01.a1_0_5_01;

public class AlphaVersion extends JavaVersion {

	public AlphaVersion(Versions ver) {
		super(ver);
		this.networkType = "alpha";
	}
	
	public void registerVersions() {
		instance.registerVersion(new a1_0_5(instance));
		instance.registerVersion(new a1_0_5_01(instance));
	}

}
