package io.github.SprainedSpark89.netmapp.model;

public class ArgDescriptor {
    private final Class<?> type;
    private final String name; // logical name e.g., "username", "seed"
    private final String description; // human readable description

    public ArgDescriptor(Class<?> type, String name, String description) {
        this.type = type;
        this.name = name;
        this.description = description;
    }

    public static ArgDescriptor of(Class<?> type) {
        return new ArgDescriptor(type, null, null);
    }

    public static ArgDescriptor of(Class<?> type, String name) {
        return new ArgDescriptor(type, name, null);
    }

    public static ArgDescriptor of(Class<?> type, String name, String description) {
        return new ArgDescriptor(type, name, description);
    }

    public Class<?> getType() { return type; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        String tn = type.isArray() ? type.getComponentType().getSimpleName() + "[]" : type.getSimpleName();
        if (name != null) return String.format("%s %s", tn, name);
        return tn;
    }
}
