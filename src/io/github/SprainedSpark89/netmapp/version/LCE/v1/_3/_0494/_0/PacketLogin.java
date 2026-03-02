package io.github.SprainedSpark89.netmapp.version.LCE.v1._3._0494._0;

import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;

public class PacketLogin extends Packet {

	public PacketLogin(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE); // int
		this.args.add(String.class); // wstring
		this.args.add(Long.TYPE); // __int64
		this.args.add(Character.TYPE); // char
		this.args.add(Object.class); // PlayerUID
		this.args.add(Character.TYPE); // char
		this.args.add(Boolean.TYPE); // bool
		this.args.add(Long.TYPE); // DWORD
		this.args.add(Integer.TYPE); // INT
		this.args.add(Byte.TYPE); // BYTE
		this.args.add(Long.TYPE); // DWORD
		this.args.add(Boolean.TYPE); // bool
		this.args.add(Boolean.TYPE); // bool
		this.args.add(Object.class); // LevelType
		this.args.add(Integer.TYPE); // unsigned int
		this.args.add(Integer.TYPE); // int
		this.args.add(Integer.TYPE); // int
		this.args.add(Integer.TYPE); // int
		this.args.add(Byte.TYPE); // BYTE
		this.args.add(Byte.TYPE); // BYTE
		
		this.argsDesc.add("Ver");
		this.argsDesc.add("Username");
		this.argsDesc.add("Seed");
		this.argsDesc.add("Dimension");
		this.argsDesc.add("xuid");
		this.argsDesc.add("difficulty");
		this.argsDesc.add("friends only ugc");
		this.argsDesc.add("ugc player ver");
		this.argsDesc.add("instance id");
		this.argsDesc.add("player index");
		this.argsDesc.add("Ver");
	}

}
