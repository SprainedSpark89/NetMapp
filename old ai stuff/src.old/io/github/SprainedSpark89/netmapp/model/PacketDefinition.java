package io.github.SprainedSpark89.netmapp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PacketDefinition {
    private final String name;
    private final int id;
    private final Direction direction;
    private final List<FieldDefinition> fields = new ArrayList<>();

    public enum Direction { CLIENTBOUND, SERVERBOUND }

    public PacketDefinition(String name, int id, Direction direction) {
        this.name = name;
        this.id = id;
        this.direction = direction;
    }

    public PacketDefinition addField(FieldDefinition field) {
        fields.add(field);
        return this;
    }

    public List<FieldDefinition> getFields() {
        return Collections.unmodifiableList(fields);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "PacketDefinition{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", direction=" + direction +
                ", fields=" + fields +
                '}';
    }
}
