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
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w23a.r12w23a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w24a.r12w24a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w25a.r12w25a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w27a.r12w27a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w30a.r12w30a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w30c.r12w30c;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w32a.r12w32a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w34a.r12w34a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w34b.r12w34b;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w36a.r12w36a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w37a.r12w37a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w38a.r12w38a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w39b.r12w39b;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w40a.r12w40a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w40b.r12w40b;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w41a.r12w41a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w42b.r12w42b;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w49a.r12w49a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w50a.r12w50a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w01a.r13w01a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w02a.r13w02a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w05a.r13w05a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w06a.r13w06a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w09a.r13w09a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w09c.r13w09c;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w16a.r13w16a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w16b.r13w16b;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w17a.r13w17a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w18a.r13w18a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w19a.r13w19a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w21a.r13w21a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w23a.r13w23b;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w24a.r13w24a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w24b.r13w24b;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w25a.r13w25a;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r13w26a.r13w26a;

public class ReleaseSnapshotVersion extends ReleaseVersion {

	public ReleaseSnapshotVersion(Versions ver) {
		super(ver);
		this.networkType = "release snapshot";
	}
	
	@Override
	public void registerVersions() { // please note that some of these are basically copies of each other, but are added due to other incompatibilities, like new items or blocks
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
		instance.registerVersion(new r12w23a(instance)); // 12w23a-b
		instance.registerVersion(new r12w24a(instance)); // 12w24a
		instance.registerVersion(new r12w25a(instance)); // 12w25a-12w26a
		instance.registerVersion(new r12w27a(instance)); // 12w27a
		instance.registerVersion(new r12w30a(instance)); // 12w30a-b
		instance.registerVersion(new r12w30c(instance)); // 12w30c-1.3.2
		instance.registerVersion(new r12w32a(instance)); // 12w32a
		instance.registerVersion(new r12w34a(instance)); // 12w34a
		instance.registerVersion(new r12w34b(instance)); // 12w34b
		instance.registerVersion(new r12w36a(instance)); // 12w36a
		instance.registerVersion(new r12w37a(instance)); // 12w37a
		instance.registerVersion(new r12w38a(instance)); // 12w38a-12w39a
		instance.registerVersion(new r12w39b(instance)); // 12w39b
		instance.registerVersion(new r12w40a(instance)); // 12w40a
		instance.registerVersion(new r12w40b(instance)); // 12w40b
		instance.registerVersion(new r12w41a(instance)); // 12w41a-12w42a
		instance.registerVersion(new r12w42b(instance)); // 12w42b-1.4.2
		instance.registerVersion(new r12w49a(instance)); // 12w49a
		instance.registerVersion(new r12w50a(instance)); // 12w50a-1.4.7
		instance.registerVersion(new r13w01a(instance)); // 13w01a-b
		instance.registerVersion(new r13w02a(instance)); // 13w02a-b
		instance.registerVersion(new r13w05a(instance)); // 13w05a-b
		instance.registerVersion(new r13w06a(instance)); // 13w06a-13w07a
		instance.registerVersion(new r13w09a(instance)); // 13w09a-b
		instance.registerVersion(new r13w09c(instance)); // 13w09c-1.5.1
		instance.registerVersion(new r13w16a(instance)); // 13w16a
		instance.registerVersion(new r13w16b(instance)); // 13w16b
		instance.registerVersion(new r13w17a(instance)); // 13w17a
		instance.registerVersion(new r13w18a(instance)); // 13w18a-13w18c
		instance.registerVersion(new r13w19a(instance)); // 13w19a
		instance.registerVersion(new r13w21a(instance)); // 13w21a-13w23a
		instance.registerVersion(new r13w23b(instance)); // 13w23b
		instance.registerVersion(new r13w24a(instance)); // 13w24a
		instance.registerVersion(new r13w24b(instance)); // 13w24b
		instance.registerVersion(new r13w25a(instance)); // 13w25a-13w25c
		instance.registerVersion(new r13w26a(instance)); // 13w26a-1.6
	}

}
