package io.github.SprainedSpark89.netmapp.version.base;

public class VersionRegisterHook {
	public void registerVersions() {
		Versions versions = new Versions(Versions.instance);
		versions.registerVersions();
	}
}
