package io.github.SprainedSpark89.netmapp.converter;

import io.github.SprainedSpark89.netmapp.model.SimplePacket;

import java.util.*;

public class PacketConverter {

    public static class Suggestion {
        public final SimplePacket source;
        public final SimplePacket target;
        public final double score;

        public Suggestion(SimplePacket source, SimplePacket target, double score) {
            this.source = source;
            this.target = target;
            this.score = score;
        }

        @Override
        public String toString() {
            return String.format("Suggestion{src=%s, tgt=%s, score=%.3f}", source, target, score);
        }
    }

    public static List<Suggestion> suggest(SimplePacket src, Collection<SimplePacket> targets) {
        List<Suggestion> result = new ArrayList<>();
        for (SimplePacket t : targets) {
            double s = score(src, t);
            result.add(new Suggestion(src, t, s));
        }
        result.sort(Comparator.comparingDouble((Suggestion x) -> -x.score));
        return result;
    }

    private static double score(SimplePacket a, SimplePacket b) {
        double score = 0.0;
        if (a.getName().equalsIgnoreCase(b.getName())) score += 0.5;
        // name token overlap
        Set<String> atoks = new HashSet<>(Arrays.asList(a.getName().toLowerCase().split("_|\\W+")));
        Set<String> btoks = new HashSet<>(Arrays.asList(b.getName().toLowerCase().split("_|\\W+")));
        atoks.retainAll(btoks);
        if (!atoks.isEmpty()) score += 0.2;

        // args similarity
        Class<?>[] aa = a.getArgs();
        Class<?>[] ba = b.getArgs();
        int min = Math.min(aa.length, ba.length);
        int common = 0;
        for (int i = 0; i < min; i++) {
            if (sameType(aa[i], ba[i])) common++;
        }
        score += 0.2 * ((double) common / Math.max(1, Math.max(aa.length, ba.length)));

        // len penalty
        if (Math.abs(aa.length - ba.length) > 0) score -= 0.05 * Math.abs(aa.length - ba.length);

        return Math.max(0.0, Math.min(1.0, score));
    }

    public static boolean sameType(Class<?> x, Class<?> y) {
        if (x == y) return true;
        if (x.isPrimitive() && y.isPrimitive()) return x.getName().equals(y.getName());
        // treat byte and Byte similarly etc
        String xn = canonicalName(x);
        String yn = canonicalName(y);
        return xn.equals(yn);
    }

    private static String canonicalName(Class<?> c) {
        if (c.isArray()) return canonicalName(c.getComponentType()) + "[]";
        String n = c.getName();
        if (n.equals("java.lang.Byte")) return "byte";
        if (n.equals("java.lang.Short")) return "short";
        if (n.equals("java.lang.Integer")) return "int";
        if (n.equals("java.lang.Long")) return "long";
        if (n.equals("java.lang.Float")) return "float";
        if (n.equals("java.lang.Double")) return "double";
        if (n.equals("java.lang.Boolean")) return "boolean";
        if (n.equals("java.lang.String")) return "string";
        return n;
    }
}