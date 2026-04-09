package io.github.SprainedSpark89.netmapp.version.java.release.snapshot;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.release.ReleaseVersion;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r11w49a.r11w49a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w01a.r12w01a;

public class ReleaseSnapshotVersion extends ReleaseVersion {

	public ReleaseSnapshotVersion(Versions ver) {
		super(ver);
		this.networkType = "release snapshot";
	}
	
	@Override
	public void registerVersions() {
		instance.registerVersion(new r11w49a(instance)); // 11w49a-11w50a
		instance.registerVersion(new r12w01a(instance)); // 12w01a
	}

}
