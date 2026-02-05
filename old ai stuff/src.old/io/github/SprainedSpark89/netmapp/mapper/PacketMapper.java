package io.github.SprainedSpark89.netmapp.mapper;

import io.github.SprainedSpark89.netmapp.model.FieldDefinition;
import io.github.SprainedSpark89.netmapp.model.PacketDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PacketMapper {

    public static class FieldMapping {
        public final FieldDefinition from;
        public final FieldDefinition to;
        public final double confidence;

        public FieldMapping(FieldDefinition from, FieldDefinition to, double confidence) {
            this.from = from;
            this.to = to;
            this.confidence = confidence;
        }

        @Override
        public String toString() {
            return "FieldMapping{" +
                    "from=" + from.getName() +
                    ", to=" + (to == null ? "<null>" : to.getName()) +
                    ", confidence=" + confidence +
                    '}';
        }
    }

    public static Map<Integer, List<FieldMapping>> mapPackets(PacketDefinition[] from, PacketDefinition[] to) {
        Map<Integer, List<FieldMapping>> result = new HashMap<>();

        Map<String, PacketDefinition> toByName = new HashMap<>();
        for (PacketDefinition p : to) {
            toByName.put(p.getName().toLowerCase(), p);
        }

        for (PacketDefinition src : from) {
            PacketDefinition tgt = toByName.get(src.getName().toLowerCase());
            List<FieldMapping> mappings = new ArrayList<>();
            if (tgt != null) {
                // try match by name & type
                List<FieldDefinition> srcFields = src.getFields();
                List<FieldDefinition> tgtFields = tgt.getFields();
                boolean[] used = new boolean[tgtFields.size()];
                for (int i = 0; i < srcFields.size(); i++) {
                    FieldDefinition s = srcFields.get(i);
                    FieldDefinition best = null;
                    double bestScore = 0.0;
                    for (int j = 0; j < tgtFields.size(); j++) {
                        if (used[j]) continue;
                        FieldDefinition t = tgtFields.get(j);
                        double score = scoreFieldMatch(s, t, i, j);
                        if (score > bestScore) {
                            bestScore = score;
                            best = t;
                        }
                    }
                    if (best != null) {
                        // mark used
                        for (int j = 0; j < tgtFields.size(); j++) {
                            if (tgtFields.get(j) == best) used[j] = true;
                        }
                        mappings.add(new FieldMapping(s, best, bestScore));
                    } else {
                        mappings.add(new FieldMapping(s, null, 0.0));
                    }
                }
            }
            result.put(src.getId(), mappings);
        }

        return result;
    }

    private static double scoreFieldMatch(FieldDefinition a, FieldDefinition b, int ai, int bi) {
        double score = 0.0;
        if (a.getType().equalsIgnoreCase(b.getType())) score += 0.5;
        if (a.getName() != null && b.getName() != null) {
            String na = a.getName().toLowerCase();
            String nb = b.getName().toLowerCase();
            if (na.equals(nb)) score += 0.4;
            else if (na.contains(nb) || nb.contains(na)) score += 0.2;
            else {
                int dist = levenshtein(na, nb);
                int max = Math.max(na.length(), nb.length());
                if (max > 0) score += 0.2 * (1.0 - (double) dist / max);
            }
        }
        if (ai == bi) score += 0.1;
        return score;
    }

    private static int levenshtein(String a, String b) {
        int[] costs = new int[b.length() + 1];
        for (int j = 0; j < costs.length; j++) costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }
}
