package io.github.SprainedSpark89.netmapp.converter;

import io.github.SprainedSpark89.netmapp.model.SimplePacket;

import java.util.*;

public class PacketConversionSession {
    private final Collection<SimplePacket> sources;
    private final Collection<SimplePacket> targets;
    private final Map<SimplePacket, List<PacketConverter.Suggestion>> suggestions = new LinkedHashMap<>();
    private final Map<SimplePacket, SimplePacket> chosen = new LinkedHashMap<>();

    public PacketConversionSession(Collection<SimplePacket> sources, Collection<SimplePacket> targets) {
        this.sources = sources;
        this.targets = targets;
    }

    public void computeSuggestions() {
        suggestions.clear();
        for (SimplePacket s : sources) {
            suggestions.put(s, PacketConverter.suggest(s, targets));
        }
    }

    public Map<SimplePacket, List<PacketConverter.Suggestion>> getSuggestions() {
        return suggestions;
    }

    public void autoAccept(double threshold) {
        for (Map.Entry<SimplePacket, List<PacketConverter.Suggestion>> e : suggestions.entrySet()) {
            List<PacketConverter.Suggestion> list = e.getValue();
            if (list.isEmpty()) continue;
            PacketConverter.Suggestion top = list.get(0);
            if (top.score >= threshold) {
                chosen.put(e.getKey(), top.target);
            }
        }
    }

    public Set<SimplePacket> unresolved() {
        Set<SimplePacket> out = new LinkedHashSet<>(sources);
        out.removeAll(chosen.keySet());
        return out;
    }

    public boolean setManualMapping(String sourceName, String targetName) {
        SimplePacket s = findByName(sources, sourceName);
        SimplePacket t = findByName(targets, targetName);
        if (s == null || t == null) return false;
        chosen.put(s, t);
        return true;
    }

    public Map<SimplePacket, SimplePacket> getChosenMappings() {
        return Collections.unmodifiableMap(chosen);
    }

    public Map<SimplePacket, List<String>> validate() {
        Map<SimplePacket, List<String>> issues = new LinkedHashMap<>();
        for (SimplePacket s : sources) {
            List<String> w = new ArrayList<>();
            SimplePacket t = chosen.get(s);
            if (t == null) {
                w.add("No mapping chosen");
            } else {
                // check arg lengths
                Class<?>[] sa = s.getArgs();
                Class<?>[] ta = t.getArgs();
                if (sa.length != ta.length) {
                    w.add(String.format("Arg count differs: src=%d tgt=%d", sa.length, ta.length));
                }
                int min = Math.min(sa.length, ta.length);
                for (int i = 0; i < min; i++) {
                    if (!PacketConverter.sameType(sa[i], ta[i])) {
                        w.add(String.format("Arg %d type mismatch: src=%s tgt=%s", i, sa[i].getSimpleName(), ta[i].getSimpleName()));
                    }
                }
            }
            if (!w.isEmpty()) issues.put(s, w);
        }
        return issues;
    }

    private SimplePacket findByName(Collection<SimplePacket> c, String name) {
        for (SimplePacket p : c) if (p.getName().equalsIgnoreCase(name)) return p;
        return null;
    }
}
