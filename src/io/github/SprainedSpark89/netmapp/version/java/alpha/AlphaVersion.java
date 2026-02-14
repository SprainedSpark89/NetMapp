package io.github.SprainedSpark89.netmapp.version.java.alpha;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.JavaVersion;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1010.a1_0_10;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105.a1_0_5;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01.a1_0_5_01;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.a1_0_6;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a107.a1_0_7;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a109.a1_0_9;

public class AlphaVersion extends JavaVersion {

	public AlphaVersion(Versions ver) {
		super(ver);
		this.networkType = "alpha";
	}
	
	public void registerVersions() {
		// a1.0.5-a1.0.11 same protocol number
		instance.registerVersion(new a1_0_5(instance));
		instance.registerVersion(new a1_0_5_01(instance)); // has more packets
		instance.registerVersion(new a1_0_6(instance)); // a1.0.6-a1.0.6_03
		// packet numbering change, so same protocol num, but just completely incompatible, nice
		instance.registerVersion(new a1_0_7(instance)); // a1.0.7-a1.0.8_01
		instance.registerVersion(new a1_0_9(instance)); // a1.0.9
		instance.registerVersion(new a1_0_10(instance)); // a1.0.10
	}

}
