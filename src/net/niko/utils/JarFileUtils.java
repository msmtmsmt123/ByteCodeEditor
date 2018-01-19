package net.niko.utils;

import net.niko.ByteCodeViewer;
import net.niko.jar.JarFile;

public class JarFileUtils
{

    public static void copyJar(JarFile in, JarFile out){
        try {
            ByteCodeViewer.findInstance().getClassLoader().loadClasses(in);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        ByteCodeViewer.findInstance().getClassLoader().saveAndWriteAllFiles(out);
        ByteCodeViewer.findInstance().clearSpace();
    }

}
