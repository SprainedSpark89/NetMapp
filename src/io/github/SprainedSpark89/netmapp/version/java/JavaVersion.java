package io.github.SprainedSpark89.netmapp.version.java;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.alpha.AlphaVersion;
import io.github.SprainedSpark89.netmapp.version.java.beta.BetaVersion;
import io.github.SprainedSpark89.netmapp.version.java.classic.ClassicVersion;

public class JavaVersion extends Versions {
	
	public JavaVersion(Versions ver) {
		super(ver);
		this.protocol = "tcp";
		this.defaultPort = 25565;
	}
	
	public void registerVersions() {
		ClassicVersion classicVersion = new ClassicVersion(instance);
		classicVersion.registerVersions();
		
		AlphaVersion alphaVersion = new AlphaVersion(instance);
		alphaVersion.registerVersions();
		
		BetaVersion betaVersion = new BetaVersion(instance);
		betaVersion.registerVersions();
	}
}
