package io.github.SprainedSpark89.netmapp.version.java.release.snapshot;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.release.ReleaseVersion;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r11w49a.r11w49a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w01a.r12w01a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w03a.r12w03a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w04a.r12w04a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w06a.r12w06a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w07a.r12w07a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w08a.r12w08a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w16a.r12w16a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w17a.r12w17a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w18a.r12w18a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w19a.r12w19a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w21a.r12w21a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w22a.r12w22a;

public class ReleaseSnapshotVersion extends ReleaseVersion {

	public ReleaseSnapshotVersion(Versions ver) {
		super(ver);
		this.networkType = "release snapshot";
	}
	
	@Override
	public void registerVersions() {
		instance.registerVersion(new r11w49a(instance)); // 11w49a-11w50a
		instance.registerVersion(new r12w01a(instance)); // 12w01a
		instance.registerVersion(new r12w03a(instance)); // 12w03a
		instance.registerVersion(new r12w04a(instance)); // 12w04a-12w05b
		instance.registerVersion(new r12w06a(instance)); // 12w06a
		instance.registerVersion(new r12w07a(instance)); // 12w07a-b
		instance.registerVersion(new r12w08a(instance)); // 12w08a-1.2.3
		instance.registerVersion(new r12w16a(instance)); // 12w16a
		instance.registerVersion(new r12w17a(instance)); // 12w17a
		instance.registerVersion(new r12w18a(instance)); // 12w18a
		instance.registerVersion(new r12w19a(instance)); // 12w19a
		instance.registerVersion(new r12w21a(instance)); // 12w21a-b
		instance.registerVersion(new r12w22a(instance)); // 12w22a
	}

}
