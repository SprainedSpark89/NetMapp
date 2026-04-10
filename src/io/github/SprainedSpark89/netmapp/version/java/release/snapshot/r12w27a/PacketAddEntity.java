package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w27a;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import io.github.SprainedSpark89.netmapp.NetMapp;
import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketAddEntity extends Packet {

	public PacketAddEntity(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Integer.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Byte.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Short.TYPE);
		this.args.add(Object[].class);
		this.argsDesc.add("EntityID");
		this.argsDesc.add("Entity Type");
		this.argsDesc.add("X");
		this.argsDesc.add("Y");
		this.argsDesc.add("Z");
		this.argsDesc.add("Yaw");
		this.argsDesc.add("Pitch");
		this.argsDesc.add("Head Yaw");
		this.argsDesc.add("X Vel");
		this.argsDesc.add("Y Vel");
		this.argsDesc.add("Z Vel");
		this.argsDesc.add("Data");
		this.packetID = 24;
		this.packetType = PacketType.entityAdd;
		
		this.read = new SpecialRead(true, 11);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {

	    List<Object[]> entries = new ArrayList<>();

	    while (true) {

	        byte header = (byte) NetMapp.parseArgs(this, buf, Byte.TYPE, (short) 0);

	        if ((header & 0xFF) == 127) {
	            break;
	        }

	        int type = (header & 0xE0) >> 5;
	        int id = header & 0x1F;

	        Object value = null;

	        switch (type) {

	            case 0: // Byte
	                value = NetMapp.parseArgs(this, buf, Byte.TYPE, (short) 0);
	                break;

	            case 1: // Short
	                value = NetMapp.parseArgs(this, buf, Short.TYPE, (short) 0);
	                break;

	            case 2: // Int
	                value = NetMapp.parseArgs(this, buf, Integer.TYPE, (short) 0);
	                break;

	            case 3: // Float
	                value = NetMapp.parseArgs(this, buf, Float.TYPE, (short) 0);
	                break;

	            case 4: // String
	                value = NetMapp.parseArgs(this, buf, String.class, (short) 0);
	                break;

	            case 5: // ItemStack
	                short itemId = (short) NetMapp.parseArgs(this, buf, Short.TYPE, (short) 0);

	                if (itemId >= 0) {
	                    byte size = (byte) NetMapp.parseArgs(this, buf, Byte.TYPE, (short) 0);
	                    short meta = (short) NetMapp.parseArgs(this, buf, Short.TYPE, (short) 0);
	                    value = new Object[]{itemId, size, meta};
	                } else {
	                    value = new Object[]{itemId};
	                }
	                break;
	            case 6: 
	                int[] vec3i = new int[3];
	                vec3i[0] = (int) NetMapp.parseArgs(this, buf, Integer.TYPE, (short) 0);
	                vec3i[1] = (int) NetMapp.parseArgs(this, buf, Integer.TYPE, (short) 0);
	                vec3i[2] = (int) NetMapp.parseArgs(this, buf, Integer.TYPE, (short) 0);
	                value = vec3i;
	            
	            default:
	                throw new RuntimeException("Unknown metadata type: " + type);
	        }

	        entries.add(new Object[]{type, id, value});
	    }

	    out.values.add(entries.toArray(new Object[0]));
	    desc.append("MetadataEntries[").append(entries.size()).append("], ");
	}

}
