package io.github.SprainedSpark89.netmapp;

import io.github.SprainedSpark89.netmapp.converter.PacketConverter;
import io.github.SprainedSpark89.netmapp.converter.PacketConversionSession;
import io.github.SprainedSpark89.netmapp.model.SimplePacket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class NetMapp {

    public static void main(String[] args) {
        System.out.println("NetMapp demo");

        // c0.0.15a
        List<SimplePacket> v15 = new ArrayList<>();
        v15.add(new SimplePacket("LOGIN", new Class[]{String.class}));
        v15.add(new SimplePacket("LEVEL_INITIALIZE", new Class[]{}));
        v15.add(new SimplePacket("LEVEL_DATA_CHUNK", new Class[]{Short.TYPE, byte[].class, Byte.TYPE}));
        v15.add(new SimplePacket("LEVEL_FINALIZE", new Class[]{Short.TYPE, Short.TYPE, Short.TYPE}));
        v15.add(new SimplePacket("PLACE_OR_REMOVE_TILE", new Class[]{Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE}));
        v15.add(new SimplePacket("SET_TILE", new Class[]{Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE}));
        v15.add(new SimplePacket("PLAYER_JOIN", new Class[]{Byte.TYPE, String.class, Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE}));
        v15.add(new SimplePacket("PLAYER_MOVE", new Class[]{Byte.TYPE, Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE}));
        v15.add(new SimplePacket("PLAYER_DISCONNECT", new Class[]{Byte.TYPE}));

        // c0.0.16a
        List<SimplePacket> v16 = new ArrayList<>();
        v16.add(new SimplePacket("LOGIN", new Class[]{Byte.TYPE, String.class, String.class}));
        v16.add(new SimplePacket("TIMED_OUT", new Class[]{}));
        v16.add(new SimplePacket("LEVEL_INITIALIZE", new Class[]{}));
        v16.add(new SimplePacket("LEVEL_DATA_CHUNK", new Class[]{Short.TYPE, byte[].class, Byte.TYPE}));
        v16.add(new SimplePacket("LEVEL_FINALIZE", new Class[]{Short.TYPE, Short.TYPE, Short.TYPE}));
        v16.add(new SimplePacket("PLACE_OR_REMOVE_TILE", new Class[]{Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE}));
        v16.add(new SimplePacket("SET_TILE", new Class[]{Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE}));
        v16.add(new SimplePacket("PLAYER_JOIN", new Class[]{Byte.TYPE, String.class, Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE}));
        v16.add(new SimplePacket("PLAYER_TELEPORT", new Class[]{Byte.TYPE, Short.TYPE, Short.TYPE, Short.TYPE, Byte.TYPE, Byte.TYPE}));
        v16.add(new SimplePacket("PLAYER_MOVE_AND_ROTATE", new Class[]{Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE}));
        v16.add(new SimplePacket("PLAYER_MOVE", new Class[]{Byte.TYPE, Byte.TYPE, Byte.TYPE, Byte.TYPE}));
        v16.add(new SimplePacket("PLAYER_ROTATE", new Class[]{Byte.TYPE, Byte.TYPE, Byte.TYPE}));
        v16.add(new SimplePacket("PLAYER_DISCONNECT", new Class[]{Byte.TYPE}));
        v16.add(new SimplePacket("CHAT_MESSAGE", new Class[]{Byte.TYPE, String.class}));
        v16.add(new SimplePacket("KICK_PLAYER", new Class[]{String.class}));

        // create a session and compute suggestions
        PacketConversionSession session = new PacketConversionSession(v15, v16);
        session.computeSuggestions();

        System.out.println("\nTop suggestions for each source packet (top 3):");
        for (Map.Entry<SimplePacket, List<PacketConverter.Suggestion>> e : session.getSuggestions().entrySet()) {
            System.out.println("Source: " + e.getKey());
            List<PacketConverter.Suggestion> list = e.getValue();
            for (int i = 0; i < Math.min(3, list.size()); i++) {
                System.out.println("  " + list.get(i));
            }
        }

        // auto-accept high-confidence ones
        session.autoAccept(0.8);

        System.out.println("\nAuto-accepted mappings (>=0.8):");
        for (Map.Entry<SimplePacket, SimplePacket> e : session.getChosenMappings().entrySet()) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }

        System.out.println("\nUnresolved sources:");
        for (SimplePacket s : session.unresolved()) {
            System.out.println("  " + s);
        }

        // Example manual mapping entry: map LOGIN -> LOGIN
        boolean ok = session.setManualMapping("LOGIN", "LOGIN");
        System.out.println("\nManual mapping LOGIN->LOGIN: " + ok);

        System.out.println("\nValidation results:");
        for (Map.Entry<SimplePacket, List<String>> e : session.validate().entrySet()) {
            System.out.println("Source: " + e.getKey());
            for (String w : e.getValue()) System.out.println("  - " + w);
        }
    }
}