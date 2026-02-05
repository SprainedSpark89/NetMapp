package io.github.SprainedSpark89.netmapp;

import io.github.SprainedSpark89.netmapp.model.Packet;

public class Mapping {
    private final Packet from;
    private final Packet to;

    public Mapping(Packet from, Packet to) {
        this.from = from;
        this.to = to;
    }

    public Packet getFrom() { return from; }
    public Packet getTo() { return to; }

    @Override
    public String toString() {
        return from + " -> " + to;
    }
}
