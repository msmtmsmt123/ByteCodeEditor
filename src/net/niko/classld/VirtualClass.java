package net.niko.classld;

import net.niko.asm.ByteClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

public class VirtualClass extends ClassNode
{

    public VirtualClass(){
        super(Opcodes.ASM5);
    }

    public byte[] write(boolean log, boolean flags){
        ByteClassWriter bcw = new ByteClassWriter(flags);
        this.accept(bcw);
        byte[] array = bcw.toByteArray();
        if(log){
            System.out.println("Writing bytes " + array.length);
        }
        return array;
    }

    public byte[] write(boolean flags){
        return write(false, flags);
    }

    public byte[] write(){
        return write(false, false);
    }

}
