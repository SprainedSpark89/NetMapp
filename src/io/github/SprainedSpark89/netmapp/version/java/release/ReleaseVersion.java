package io.github.SprainedSpark89.netmapp.version.java.release;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.JavaVersion;
import io.github.SprainedSpark89.netmapp.version.java.release.candidate.ReleaseCandidateVersion;
import io.github.SprainedSpark89.netmapp.version.java.release.r11.r1_1;
import io.github.SprainedSpark89.netmapp.version.java.release.r124.r1_2_4;
import io.github.SprainedSpark89.netmapp.version.java.release.r143.r1_4_3;
import io.github.SprainedSpark89.netmapp.version.java.release.r144.r1_4_4;
import io.github.SprainedSpark89.netmapp.version.java.release.snapshot.ReleaseSnapshotVersion;

public class ReleaseVersion extends JavaVersion {

	public ReleaseVersion(Versions ver) {
		super(ver);
		this.networkType = "release";
	}
	
	public void registerVersions() {
		ReleaseCandidateVersion releaseCandidateVersion = new ReleaseCandidateVersion(instance);
		releaseCandidateVersion.registerVersions(); // All RC Versions
		
		ReleaseSnapshotVersion releaseSnapshotVersion = new ReleaseSnapshotVersion(instance);
		releaseSnapshotVersion.registerVersions(); // All Snapshot Versions
		
		instance.registerVersion(new r1_1(instance));
		instance.registerVersion(new r1_2_4(instance)); // 1.2.4-12w15a
		instance.registerVersion(new r1_4_3(instance)); // 1.4.3
		instance.registerVersion(new r1_4_4(instance)); // 1.4.4-1.4.5
	}

}
