package io.github.SprainedSpark89.netmapp;

import io.github.SprainedSpark89.netmapp.model.Packet;

import java.util.LinkedHashMap;
import java.util.Map;

public class Version {
    private final String name;
    private final Map<String, Packet> packetsByName = new LinkedHashMap<>();

    public Version(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void register(Packet p) {
        packetsByName.put(p.getName(), p);
    }

    public Packet getByName(String name) {
        return packetsByName.get(name);
    }

    public Map<String, Packet> getPackets() { return packetsByName; }
}
