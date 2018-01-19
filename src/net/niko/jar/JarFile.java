package net.niko.jar;

import java.io.File;
import java.util.Objects;

public class JarFile extends File
{
    public JarFile(String pathname) {
        super(pathname);
    }

    public boolean isValid(){
        return this.exists() && this.getAbsolutePath().endsWith(".jar");
    }

}
