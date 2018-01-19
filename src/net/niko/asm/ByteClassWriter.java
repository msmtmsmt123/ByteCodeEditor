package net.niko.asm;

import org.objectweb.asm.ClassWriter;

public class ByteClassWriter extends ClassWriter
{

    public ByteClassWriter(boolean flags) {
        super(flags ? ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS : 0);
    }
}
