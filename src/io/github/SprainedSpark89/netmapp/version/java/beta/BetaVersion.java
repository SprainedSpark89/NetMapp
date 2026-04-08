package io.github.SprainedSpark89.netmapp.version.java.beta;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.JavaVersion;
import io.github.SprainedSpark89.netmapp.version.java.beta.b10.b1_0;
import io.github.SprainedSpark89.netmapp.version.java.beta.b11_02.b1_1_02;
import io.github.SprainedSpark89.netmapp.version.java.beta.b12.b1_2;
import io.github.SprainedSpark89.netmapp.version.java.beta.b13.b1_3;
import io.github.SprainedSpark89.netmapp.version.java.beta.b14.b1_4;
import io.github.SprainedSpark89.netmapp.version.java.beta.b15.b1_5;
import io.github.SprainedSpark89.netmapp.version.java.beta.b16.b1_6;
import io.github.SprainedSpark89.netmapp.version.java.beta.b17.b1_7;
import io.github.SprainedSpark89.netmapp.version.java.beta.preview.BetaPreviewVersion;
import io.github.SprainedSpark89.netmapp.version.java.beta.test_build.BetaTestBuildVersion;

public class BetaVersion extends JavaVersion {

	public BetaVersion(Versions ver) {
		super(ver);
		// TODO Auto-generated constructor stub
		this.networkType = "beta";
	}
	
	public void registerVersions() {
		instance.registerVersion(new b1_0(instance)); // b1.0-b1.1_01
		instance.registerVersion(new b1_1_02(instance)); // b1.1_02
		instance.registerVersion(new b1_2(instance)); // b1.2-b1.2_02
		instance.registerVersion(new b1_3(instance)); // b1.3-b1.3_01
		instance.registerVersion(new b1_4(instance)); // b1.4-b1.4_01
		instance.registerVersion(new b1_5(instance)); // b1.5-b1.5_02
		
		BetaPreviewVersion previewVersion = new BetaPreviewVersion(instance);
		previewVersion.registerVersions(); // b1.6-preview and b1.7-preview
		
		BetaTestBuildVersion tBVersion = new BetaTestBuildVersion(instance);
		tBVersion.registerVersions(); // b1.6-tb3
		
		instance.registerVersion(new b1_6(instance));
		instance.registerVersion(new b1_7(instance));
		
	}

}
