package io.github.SprainedSpark89.netmapp.version.java.release.candidate;

import io.github.SprainedSpark89.netmapp.version.base.Versions;
import io.github.SprainedSpark89.netmapp.version.java.release.ReleaseVersion;

public class ReleaseCandidateVersion extends ReleaseVersion {

	public ReleaseCandidateVersion(Versions ver) {
		super(ver);
		this.networkType = "release candidate";
	}
	
	@Override
	public void registerVersions() {
		
	}

}
