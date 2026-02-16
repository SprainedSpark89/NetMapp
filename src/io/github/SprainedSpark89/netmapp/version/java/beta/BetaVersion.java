package io.github.SprainedSpark89.netmapp.version.java.beta;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.JavaVersion;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.b1_0;
import io.github.SprainedSpark89.netmapp.version.java.beta.b11_02.b1_1_02;

public class BetaVersion extends JavaVersion {

	public BetaVersion(Versions ver) {
		super(ver);
		// TODO Auto-generated constructor stub
		this.networkType = "beta";
	}
	
	public void registerVersions() {
		instance.registerVersion(new b1_0(instance)); // b1.0-b1.1_01
		instance.registerVersion(new b1_1_02(instance)); // b1.1_02
	}

}
