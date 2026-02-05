package io.github.SprainedSpark89.netmapp;

import io.github.SprainedSpark89.netmapp.model.ArgDescriptor;
import io.github.SprainedSpark89.netmapp.model.Packet;

import java.util.*;

public class Converter {
    private final Map<String, Version> versions = new LinkedHashMap<>();
    private final MappingRegistry mappingRegistry = new MappingRegistry();

    public void registerVersion(Version v) { versions.put(v.getName(), v); }

    public Version getVersion(String name) { return versions.get(name); }

    public void registerMapping(String fromVersion, String toVersion, Packet fromPacket, Packet toPacket) {
        mappingRegistry.register(fromVersion, toVersion, fromPacket, toPacket);
    }

    public ConversionResult convert(String fromVersion, String toVersion, String packetName, Object[] args) {
        List<String> extras = new ArrayList<>();

        // If direct mapping exists, use it
        Packet mapped = mappingRegistry.getMapping(fromVersion, toVersion, packetName);
        if (mapped != null) {
            // attempt to map args by position where types are compatible; unmatched are pushed to extras
            Packet src = versions.get(fromVersion).getByName(packetName);
            Object[] newArgs = mapArgs(src, mapped, args, extras);
            return new ConversionResult(mapped, newArgs, extras);
        }

        // no mapping found; return original packet as-is and store values in extras
        Packet src = versions.get(fromVersion).getByName(packetName);
        extras.add("No mapping for packet: " + packetName);
        if (args != null) {
            ArgDescriptor[] desc = src.getArgDescriptors();
            for (int i = 0; i < args.length; i++) {
                String label = i < desc.length && desc[i].getName() != null ? desc[i].getName() : "arg" + i;
                extras.add("value:" + label + "=" + String.valueOf(args[i]));
            }
        }
        return new ConversionResult(src, args, extras);
    }

    private Object[] mapArgs(Packet src, Packet tgt, Object[] args, List<String> extras) {
        if (args == null) args = new Object[0];
        Class<?>[] sTypes = src.getArgTypes();
        Class<?>[] tTypes = tgt.getArgTypes();
        ArgDescriptor[] sDesc = src.getArgDescriptors();
        ArgDescriptor[] tDesc = tgt.getArgDescriptors();
        int tlen = tTypes.length;
        Object[] out = new Object[tlen];
        int min = Math.min(sTypes.length, tlen);
        for (int i = 0; i < min; i++) {
            Object val = i < args.length ? args[i] : null;
            if (val != null && isCompatible(sTypes[i], tTypes[i])) {
                out[i] = val; // straightforward copy
            } else {
                // cannot map directly, push to extras
                String label = i < sDesc.length && sDesc[i].getName() != null ? sDesc[i].getName() : "arg" + i;
                String targ = i < tDesc.length && tDesc[i].getName() != null ? tDesc[i].getName() : "arg" + i;
                String valType = val == null ? "null" : val.getClass().getSimpleName();
                extras.add(String.format("unmapped: src[%s:%s]=%s -> tgt[%s:%s]", i, label, valType, i, targ));
                out[i] = defaultValueFor(tTypes[i]);
            }
        }
        // if target has more args than source, fill defaults
        for (int i = min; i < tlen; i++) {
            out[i] = defaultValueFor(tTypes[i]);
            String targ = i < tDesc.length && tDesc[i].getName() != null ? tDesc[i].getName() : "arg" + i;
            extras.add(String.format("targetDefault: tgt[%d:%s]=%s", i, targ, tTypes[i].getSimpleName()));
        }
        // if source has extra args, stash them
        for (int i = min; i < sTypes.length && i < args.length; i++) {
            String label = i < sDesc.length && sDesc[i].getName() != null ? sDesc[i].getName() : "arg" + i;
            extras.add(String.format("sourceExtra: src[%d:%s]=%s", i, label, args[i] == null ? "null" : args[i].toString()));
        }
        return out;
    }

    private boolean isCompatible(Class<?> s, Class<?> t) {
        if (s == t) return true;
        // primitive vs boxed
        if (s.isPrimitive() && !t.isPrimitive()) return boxedOf(s) == t;
        if (!s.isPrimitive() && t.isPrimitive()) return boxedOf(t) == s;
        if (s.isArray() && t.isArray()) return isCompatible(s.getComponentType(), t.getComponentType());
        return false;
    }

    private Class<?> boxedOf(Class<?> prim) {
        if (!prim.isPrimitive()) return prim;
        if (prim == byte.class) return Byte.class;
        if (prim == short.class) return Short.class;
        if (prim == int.class) return Integer.class;
        if (prim == long.class) return Long.class;
        if (prim == float.class) return Float.class;
        if (prim == double.class) return Double.class;
        if (prim == boolean.class) return Boolean.class;
        if (prim == char.class) return Character.class;
        return prim;
    }

    private Object defaultValueFor(Class<?> t) {
        if (t.isPrimitive()) {
            if (t == byte.class) return (byte)0;
            if (t == short.class) return (short)0;
            if (t == int.class) return 0;
            if (t == long.class) return 0L;
            if (t == float.class) return 0f;
            if (t == double.class) return 0d;
            if (t == boolean.class) return false;
            if (t == char.class) return '\0';
        }
        if (t.isArray()) return java.lang.reflect.Array.newInstance(t.getComponentType(), 0);
        return null;
    }

    /**
     * Convert a packet through a chain of versions.
     * chain must be an ordered list of version names with at least two entries: from -> ... -> to
     */
    public ConversionResult convertChained(List<String> chain, String packetName, Object[] args) {
        if (chain == null || chain.size() < 2) throw new IllegalArgumentException("chain must contain at least two versions");
        Object[] currentArgs = args;
        String currentPacketName = packetName;
        List<String> accumulatedExtras = new ArrayList<>();

        for (int i = 0; i < chain.size() - 1; i++) {
            String fromV = chain.get(i);
            String toV = chain.get(i + 1);
            ConversionResult r = convert(fromV, toV, currentPacketName, currentArgs);
            // merge extras
            accumulatedExtras.addAll(r.getExtras());
            // update for next hop
            currentArgs = r.getArgs();
            currentPacketName = r.getPacket().getName();
        }

        // final packet object from the last hop
        Packet finalPacket = versions.get(chain.get(chain.size() - 1)).getByName(currentPacketName);
        if (finalPacket == null) {
            // if final version doesn't have that packet registered, create a placeholder packet using last known name
            finalPacket = new Packet(currentPacketName, null, new Class[]{});
        }
        return new ConversionResult(finalPacket, currentArgs, accumulatedExtras);
    }

    public static class ConversionResult {
        private final Packet packet;
        private final Object[] args;
        private final List<String> extras;

        public ConversionResult(Packet packet, Object[] args, List<String> extras) {
            this.packet = packet;
            this.args = args == null ? new Object[0] : args.clone();
            this.extras = new ArrayList<>(extras);
        }

        public Packet getPacket() { return packet; }
        public Object[] getArgs() { return args.clone(); }
        public List<String> getExtras() { return Collections.unmodifiableList(extras); }
    }
}