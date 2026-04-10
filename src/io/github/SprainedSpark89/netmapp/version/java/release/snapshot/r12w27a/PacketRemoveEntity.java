package io.github.SprainedSpark89.netmapp.version.java.release.snapshot.r12w27a;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.List;

import io.github.SprainedSpark89.netmapp.version.base.Packet;
import io.github.SprainedSpark89.netmapp.version.base.PacketType;
import io.github.SprainedSpark89.netmapp.version.base.ParsedPacket;
import io.github.SprainedSpark89.netmapp.version.base.SpecialRead;

public class PacketRemoveEntity extends Packet {

	public PacketRemoveEntity(List<Class<?>> inputs, List<String> descriptions) {
		super(inputs, descriptions);
		// TODO Auto-generated constructor stub
		this.args.add(Byte.TYPE);
		this.args.add(int[].class);
		this.argsDesc.add("EntityID list length");
		this.argsDesc.add("EntityIDs");
		this.packetType = PacketType.entityRemove;
		this.packetID = 29;
		
		this.read = new SpecialRead(true, 1);
	}
	
	@Override
	public void read(ByteBuffer buf, ParsedPacket out, StringBuilder desc, Class<?> arg) {
		int size = (int)(byte) out.values.get(out.values.size() - 1);

	    if (buf.remaining() < size * 2)
	        throw new BufferUnderflowException();

	    int[] arr = new int[size];

	    for (int i1 = 0; i1 < size; i1++) {
	        arr[i1] = buf.getInt();
	    }
	    
	    out.values.add(arr);
	    desc.append("IntegerArray[").append(size).append("], ");
	}

}
