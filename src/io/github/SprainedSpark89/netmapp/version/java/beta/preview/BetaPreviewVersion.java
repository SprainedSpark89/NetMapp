package io.github.SprainedSpark89.netmapp.version.java.beta.preview;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.beta.BetaVersion;
import io.github.SprainedSpark89.netmapp.version.java.beta.preview.b16_preview.b1_6_preview;
import io.github.SprainedSpark89.netmapp.version.java.beta.preview.b17_preview.b1_7_preview;

public class BetaPreviewVersion extends BetaVersion {

	public BetaPreviewVersion(Versions ver) {
		super(ver);
		// TODO Auto-generated constructor stub
		this.networkType = "beta preview";
	}
	
	@Override
	public void registerVersions() {
		instance.registerVersion(new b1_6_preview(instance)); // b1.6-preview
		instance.registerVersion(new b1_7_preview(instance)); // b1.7-preview
	}

}
