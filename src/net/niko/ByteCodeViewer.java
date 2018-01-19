package net.niko;

import net.niko.classld.VirtualClass;
import net.niko.classld.VirtualClassLoader;
import net.niko.classld.VirtualFile;

import java.util.ArrayList;

public class ByteCodeViewer
{

    private static ByteCodeViewer instance;

    public static final ArrayList<VirtualClass> CLASSES = new ArrayList<>();
    public static final ArrayList<VirtualFile> FILES = new ArrayList<>();

    private VirtualClassLoader classLoader;

    public ByteCodeViewer(){
        instance = this;
        classLoader = new VirtualClassLoader();
    }

    public static ByteCodeViewer findInstance(){
        return instance;
    }

    public VirtualClassLoader getClassLoader() {
        return classLoader;
    }

    public void clearSpace() {
        FILES.clear();
        CLASSES.clear();
    }
}
