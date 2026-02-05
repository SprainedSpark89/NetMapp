package io.github.SprainedSpark89.netmapp;

import io.github.SprainedSpark89.netmapp.model.Packet;

import java.util.LinkedHashMap;
import java.util.Map;

public class MappingRegistry {
    // key = fromVersion->toVersion string like "v1->v2" ; but simpler: nested map
    private final Map<String, Map<String, Map<String, Packet>>> mappings = new LinkedHashMap<>();

    public void register(String fromVersion, String toVersion, Packet fromPacket, Packet toPacket) {
        mappings.computeIfAbsent(fromVersion, k -> new LinkedHashMap<>())
                .computeIfAbsent(toVersion, k -> new LinkedHashMap<>())
                .put(fromPacket.getName(), toPacket);
    }

    public Packet getMapping(String fromVersion, String toVersion, String fromPacketName) {
        Map<String, Map<String, Packet>> fmap = mappings.get(fromVersion);
        if (fmap == null) return null;
        Map<String, Packet> inner = fmap.get(toVersion);
        if (inner == null) return null;
        return inner.get(fromPacketName);
    }
}
