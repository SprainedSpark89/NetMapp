package io.github.SprainedSpark89.netmapp.version.java.beta.prerelease;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.beta.BetaVersion;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre1.b1_8_pre1;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b18_pre2.b1_8_pre2;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre1.b1_9_pre1;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre2.b1_9_pre2;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre3.b1_9_pre3;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre4.b1_9_pre4;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre5.b1_9_pre5;
import io.github.SprainedSpark89.netmapp.version.java.beta.prerelease.b19_pre6.b1_9_pre6;

public class BetaPrereleaseVersion extends BetaVersion {

	public BetaPrereleaseVersion(Versions ver) {
		super(ver);
		this.networkType = "beta prerelease";
	}
	
	@Override
	public void registerVersions() {
		instance.registerVersion(new b1_8_pre1(instance)); // b1.8-pre1
		instance.registerVersion(new b1_8_pre2(instance)); // b1.8-pre2
		
		instance.registerVersion(new b1_9_pre1(instance)); // b1.9-pre1
		instance.registerVersion(new b1_9_pre2(instance)); // b1.9-pre2
		instance.registerVersion(new b1_9_pre3(instance)); // b1.9-pre3
		instance.registerVersion(new b1_9_pre4(instance)); // b1.9-pre4
		instance.registerVersion(new b1_9_pre5(instance)); // b1.9-pre5
		instance.registerVersion(new b1_9_pre6(instance)); // b1.9-pre6-11w48a
	}

}
