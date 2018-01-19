package net.niko.gui;

import lombok.Getter;
import net.niko.ByteCodeViewer;
import net.niko.classld.VirtualClass;
import net.niko.jar.JarFile;
import net.niko.utils.JarFileUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

@Getter
public class Gui
{

    private Window window;
    private JFrame frame;

    private JSplitPane splitPane;

    private JList<String> classTree;

    private DefaultListModel<String> defaultListModel;

    private JTabbedPane tabbedPane;

    private NikoFrame nikoFrame;

    public Gui(){
        window = new Window(ByteCodeViewer.TITLE, ByteCodeViewer.WIDTH, ByteCodeViewer.HEIGHT);
        frame = window.createWindow();

        splitPane = new JSplitPane();
        frame.add(splitPane, BorderLayout.CENTER);
        splitPane.setVisible(true);

        openFile();

        defaultListModel = new DefaultListModel<String>();
        for(VirtualClass virtualClass : ByteCodeViewer.CLASSES){
            defaultListModel.addElement(virtualClass.name.replaceAll("/", "."));
        }
        classTree = new JList<String>(defaultListModel);
        classTree.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String val = classTree.getModel().getElementAt(classTree.getSelectedIndex());
                if(val != null) {
                    if(JarFileUtils.getVirtualClass(val) != null){
                        nikoFrame.update(JarFileUtils.getVirtualClass(val));
                    }
                }
            }
        });
        splitPane.setLeftComponent(classTree);
        classTree.setVisible(true);

        nikoFrame = new NikoFrame();
        tabbedPane = nikoFrame.createPane();
        splitPane.setRightComponent(tabbedPane);
        tabbedPane.setVisible(true);

        frame.setVisible(true);
    }

    public void openFile(){
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        if(jfc.getSelectedFile() != null){
            JarFile file = new JarFile(jfc.getSelectedFile().getAbsolutePath());
            if(file.isValid()){
                try {
                    ByteCodeViewer.findInstance().getClassLoader().loadClasses(file);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }
    }

}
