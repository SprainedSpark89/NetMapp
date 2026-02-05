package io.github.SprainedSpark89.netmapp;



import io.github.SprainedSpark89.netmapp.model.ArgDescriptor;
import io.github.SprainedSpark89.netmapp.model.Packet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NetMapp {

    public static void main(String[] args) {
        // minimal demo of framework with arg descriptors
        Converter converter = new Converter();

        Version v15 = new Version("c0.0.15a");
        v15.register(new Packet("LOGIN", new ArgDescriptor[]{
                ArgDescriptor.of(String.class, "username", "Player username")
        }));
        v15.register(new Packet("LEVEL_INITIALIZE", new ArgDescriptor[]{}));
        v15.register(new Packet("PLAYER_MOVE", new ArgDescriptor[]{
                ArgDescriptor.of(byte.class, "playerId", "Id of player"),
                ArgDescriptor.of(short.class, "x", "X position"),
                ArgDescriptor.of(short.class, "y", "Y position"),
                ArgDescriptor.of(short.class, "z", "Z position"),
                ArgDescriptor.of(byte.class, "onGround", "On-ground flag"),
                ArgDescriptor.of(byte.class, "unused", "Extra flag")
        }));
        converter.registerVersion(v15);

        Version v16 = new Version("c0.0.16a");
        v16.register(new Packet("LOGIN", new ArgDescriptor[]{
                ArgDescriptor.of(byte.class, "protocolVersion", "protocol version byte"),
                ArgDescriptor.of(String.class, "username", "Player username"),
                ArgDescriptor.of(String.class, "unusedAuth", "auth token or unused")
        }));
        v16.register(new Packet("LEVEL_INITIALIZE", new ArgDescriptor[]{}));
        v16.register(new Packet("PLAYER_MOVE", new ArgDescriptor[]{
                ArgDescriptor.of(byte.class, "playerId", "Id of player"),
                ArgDescriptor.of(byte.class, "dx", "delta X compact"),
                ArgDescriptor.of(byte.class, "dy", "delta Y compact"),
                ArgDescriptor.of(byte.class, "dz", "delta Z compact")
        }));
        converter.registerVersion(v16);

        // register a mapping from v15 -> v16 for LOGIN and PLAYER_MOVE
        converter.registerMapping("c0.0.15a", "c0.0.16a", v15.getByName("LOGIN"), v16.getByName("LOGIN"));
        converter.registerMapping("c0.0.15a", "c0.0.16a", v15.getByName("PLAYER_MOVE"), v16.getByName("PLAYER_MOVE"));

        // simulate converting a LOGIN packet
        Object[] loginArgs = new Object[]{"Player123"};
        Converter.ConversionResult cr = converter.convert("c0.0.15a", "c0.0.16a", "LOGIN", loginArgs);
        System.out.println("Converted packet: " + cr.getPacket());
        System.out.println("Args: java.util.Arrays.toString(cr.getArgs()) = " + Arrays.toString(cr.getArgs()));
        System.out.println("Extras: " + cr.getExtras());

        // simulate converting a PLAYER_MOVE packet with extra fields preserved
        Object[] moveArgs = new Object[]{(byte)0, (short)10, (short)20, (short)30, (byte)1, (byte)0};
        Converter.ConversionResult mv = converter.convert("c0.0.15a", "c0.0.16a", "PLAYER_MOVE", moveArgs);
        System.out.println("Converted packet: " + mv.getPacket());
        System.out.println("Args: " + Arrays.toString(mv.getArgs()));
        System.out.println("Extras: " + mv.getExtras());

        // chained conversion example: c0.0.15a -> c0.0.16a -> c0.0.15a (roundtrip)
        List<String> chain = Arrays.asList("c0.0.15a", "c0.0.16a", "c0.0.15a");
        Converter.ConversionResult round = converter.convertChained(chain, "PLAYER_MOVE", moveArgs);
        System.out.println("\nChained conversion result packet: " + round.getPacket());
        System.out.println("Args: " + Arrays.toString(round.getArgs()));
        System.out.println("Accumulated extras: " + round.getExtras());
    }
}