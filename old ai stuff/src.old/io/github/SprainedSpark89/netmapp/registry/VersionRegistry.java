package io.github.SprainedSpark89.netmapp.registry;

import io.github.SprainedSpark89.netmapp.model.PacketDefinition;

import java.util.HashMap;
import java.util.Map;

public class VersionRegistry {
    private final String version;
    private final Map<Integer, PacketDefinition> packetsById = new HashMap<>();

    public VersionRegistry(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void register(PacketDefinition packet) {
        packetsById.put(packet.getId(), packet);
    }

    public PacketDefinition getById(int id) {
        return packetsById.get(id);
    }

    public Map<Integer, PacketDefinition> getAll() {
        return packetsById;
    }
}
