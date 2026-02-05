package io.github.SprainedSpark89.netmapp.model;

public class Packet {
    private final String name;
    private final Integer id; // optional numeric id, may be null
    private final Class<?>[] argTypes;
    private final ArgDescriptor[] argDescriptors; // optional descriptors parallel to argTypes

    public Packet(String name, Integer id, Class<?>[] argTypes) {
        this.name = name;
        this.id = id;
        this.argTypes = argTypes == null ? new Class<?>[0] : argTypes.clone();
        this.argDescriptors = null;
    }

    // new constructor with ArgDescriptor[]
    public Packet(String name, Integer id, ArgDescriptor[] argDescriptors) {
        this.name = name;
        this.id = id;
        if (argDescriptors == null) {
            this.argDescriptors = new ArgDescriptor[0];
            this.argTypes = new Class<?>[0];
        } else {
            this.argDescriptors = argDescriptors.clone();
            this.argTypes = new Class<?>[argDescriptors.length];
            for (int i = 0; i < argDescriptors.length; i++) this.argTypes[i] = argDescriptors[i].getType();
        }
    }

    public Packet(String name, Class<?>[] argTypes) {
        this(name, null, argTypes);
    }

    public Packet(String name, ArgDescriptor[] argDescriptors) {
        this(name, null, argDescriptors);
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Class<?>[] getArgTypes() {
        return argTypes.clone();
    }

    public ArgDescriptor[] getArgDescriptors() {
        return argDescriptors == null ? new ArgDescriptor[0] : argDescriptors.clone();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("(");
        for (int i = 0; i < argTypes.length; i++) {
            if (i > 0) sb.append(", ");
            Class<?> c = argTypes[i];
            if (c.isArray()) sb.append(c.getComponentType().getSimpleName()).append("[]");
            else sb.append(c.getSimpleName());
        }
        sb.append(")");
        return sb.toString();
    }
}