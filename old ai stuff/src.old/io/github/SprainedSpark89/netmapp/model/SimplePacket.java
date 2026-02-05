package io.github.SprainedSpark89.netmapp.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SimplePacket {
    private final String name;
    private final Class<?>[] args;

    public SimplePacket(String name, Class<?>[] args) {
        this.name = name;
        this.args = args == null ? new Class<?>[0] : args.clone();
    }

    public String getName() {
        return name;
    }

    public Class<?>[] getArgs() {
        return args.clone();
    }

    public String signatureString() {
        return Arrays.stream(args)
                .map(SimplePacket::typeName)
                .collect(Collectors.joining(", "));
    }

    private static String typeName(Class<?> c) {
        if (c.isArray()) {
            return typeName(c.getComponentType()) + "[]";
        }
        return c.getSimpleName();
    }

    @Override
    public String toString() {
        return name + "(" + signatureString() + ")";
    }
}
