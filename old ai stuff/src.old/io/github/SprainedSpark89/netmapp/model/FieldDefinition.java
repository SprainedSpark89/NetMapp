package io.github.SprainedSpark89.netmapp.model;

public class FieldDefinition {
    private final String name;
    private final String type;
    private final boolean optional;

    public FieldDefinition(String name, String type) {
        this(name, type, false);
    }

    public FieldDefinition(String name, String type, boolean optional) {
        this.name = name;
        this.type = type;
        this.optional = optional;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isOptional() {
        return optional;
    }

    @Override
    public String toString() {
        return "FieldDefinition{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", optional=" + optional +
                '}';
    }
}
