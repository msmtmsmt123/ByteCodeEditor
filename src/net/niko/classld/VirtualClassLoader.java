package net.niko.classld;

import me.lpk.util.JarUtils;
import net.niko.ByteCodeViewer;
import net.niko.jar.JarFile;
import org.objectweb.asm.tree.ClassNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VirtualClassLoader
{

    public void loadClasses(JarFile jar) throws Throwable{
        if(jar.isValid()){
            ByteCodeViewer.findInstance().clearSpace();
            Map<String, ClassNode> classMap = JarUtils.loadClasses(jar);
            Map<String, byte[]> other = JarUtils.loadNonClassEntries(jar);
            for(ClassNode cn : classMap.values()){
                ByteCodeViewer.CLASSES.add(new VirtualClass(cn));
            }
            for(Map.Entry<String, byte[]> entry : other.entrySet()){
                ByteCodeViewer.FILES.add(new VirtualFile(entry.getKey(), entry.getValue()));
            }
        }
    }

    public void saveAndWriteAllFiles(JarFile jar){
        Map<String, byte[]> allFiles = new HashMap<>();
        for(VirtualClass virtualClass : ByteCodeViewer.CLASSES){
            allFiles.put(virtualClass.name, virtualClass.write(true, false));
        }
        for(VirtualFile virtualFile : ByteCodeViewer.FILES){
            allFiles.put(virtualFile.getName(), virtualFile.getData());
        }
        JarUtils.saveAsJar(allFiles, jar.getAbsolutePath());
    }
}
