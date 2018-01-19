package net.niko.classld;

import net.niko.asm.ByteClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

public class VirtualClass extends ClassNode
{

    public VirtualClass(){
        super(Opcodes.ASM5);
    }

    public VirtualClass(ClassNode cn) {
        super(Opcodes.ASM5);
        this.name = cn.name;
        this.superName = cn.superName;
        this.invisibleTypeAnnotations = cn.invisibleTypeAnnotations;
        this.visibleTypeAnnotations = cn.visibleTypeAnnotations;
        this.methods = cn.methods;
        this.fields = cn.fields;
        this.sourceDebug = cn.sourceDebug;
        this.sourceFile = cn.sourceFile;
        this.interfaces = cn.interfaces;
        this.attrs = cn.attrs;
        this.outerClass = cn.outerClass;
        this.outerMethod = cn.outerMethod;
        this.outerMethodDesc = cn.outerMethodDesc;
        this.innerClasses = cn.innerClasses;
        this.invisibleAnnotations = cn.invisibleAnnotations;
        this.extraBytes = cn.extraBytes;
        this.access = cn.access;
        this.version = cn.version;
        this.signature = cn.signature;
        this.preLoad = cn.preLoad;
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
