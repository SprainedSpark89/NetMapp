package io.github.SprainedSpark89.netmapp.version.java.beta.test_build;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.beta.BetaVersion;
import io.github.SprainedSpark89.netmapp.version.java.beta.test_build.b16_tb3.b1_6_tb3;

public class BetaTestBuildVersion extends BetaVersion {

	public BetaTestBuildVersion(Versions ver) {
		super(ver);
		// TODO Auto-generated constructor stub
		this.networkType = "beta test build";
	}
	
	@Override
	public void registerVersions() {
		instance.registerVersion(new b1_6_tb3(instance)); // b1.6-tb3
	}
}
