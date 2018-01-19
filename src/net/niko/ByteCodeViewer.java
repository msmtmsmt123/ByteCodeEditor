package net.niko;

import net.niko.classld.VirtualClass;
import net.niko.classld.VirtualClassLoader;
import net.niko.classld.VirtualFile;
import net.niko.gui.Gui;

import java.util.ArrayList;

public class ByteCodeViewer
{

    private static ByteCodeViewer instance;

    public static final ArrayList<VirtualClass> CLASSES = new ArrayList<>();
    public static final ArrayList<VirtualFile> FILES = new ArrayList<>();

    public static final String TITLE = ByteCodeViewer.class.getSimpleName();
    public static final int WIDTH = 960, HEIGHT = 690;

    private VirtualClassLoader classLoader;

    private Gui gui;

    public ByteCodeViewer(){
        instance = this;
        classLoader = new VirtualClassLoader();
        gui = new Gui();
    }

    public static ByteCodeViewer findInstance(){
        return instance;
    }

    public VirtualClassLoader getClassLoader() {
        return classLoader;
    }

    public Gui getGui() {
        return gui;
    }

    public void clearSpace() {
        FILES.clear();
        CLASSES.clear();
    }
}
