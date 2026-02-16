package io.github.SprainedSpark89.netmapp.version.java.alpha;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.JavaVersion;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1010.a1_0_10;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1012.a1_0_12;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1013.a1_0_13;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1015.a1_0_15;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1016.a1_0_16;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a1017.a1_0_17;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105.a1_0_5;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a105_01.a1_0_5_01;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a106.a1_0_6;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a107.a1_0_7;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a109.a1_0_9;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a110.a1_1_0;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a120.a1_2_0;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a122.a1_2_2;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a123.a1_2_3;
import io.github.SprainedSpark89.netmapp.version.java.alpha.a123_05.a1_2_3_05;

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
		instance.registerVersion(new a1_0_10(instance)); // a1.0.10-a1.0.11
		instance.registerVersion(new a1_0_12(instance)); // a1.0.12, copy of a1.0.10 with protocol change
		instance.registerVersion(new a1_0_13(instance)); // a1.0.13-a1.0.14
		instance.registerVersion(new a1_0_15(instance)); // a1.0.15
		instance.registerVersion(new a1_0_16(instance)); // a1.0.16-a1.0.16_02
		instance.registerVersion(new a1_0_17(instance)); // a1.0.17-a1.0.17_04
		instance.registerVersion(new a1_1_0(instance)); // a1.1.0-a1.1.2_01
		instance.registerVersion(new a1_2_0(instance)); // a1.2.0-a1.2.1_01
		instance.registerVersion(new a1_2_2(instance)); // a1.2.2a-a1.2.2b
		instance.registerVersion(new a1_2_3(instance)); // a1.2.3-a1.2.3_04
		instance.registerVersion(new a1_2_3_05(instance)); // a1.2.3_05-a1.2.6
	}

}
