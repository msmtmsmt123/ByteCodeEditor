package net.niko.gui;

import lombok.Getter;
import net.niko.classld.VirtualClass;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class NikoFrame
{

    private JList<String> fields;
    private JList<String> methods;

    public JTabbedPane createPane(){
        JTabbedPane tabbedPane = new JTabbedPane();

        fields = new JList<>();
        methods = new JList<>();

        tabbedPane.addTab(TabMode.Opcodes.name(), null);
        tabbedPane.addTab(TabMode.Decompilation.name(), null);
        tabbedPane.addTab(TabMode.Fields.name(), fields);
        tabbedPane.addTab(TabMode.Methods.name(), methods);

        return tabbedPane;
    }

    public void update(VirtualClass virtualClass){
        DefaultListModel<String> fieldModel = new DefaultListModel<>();
        for(FieldNode fn : virtualClass.fields){
            fieldModel.addElement(fn.name);
        }
        fields.setModel(fieldModel);
        DefaultListModel<String> methodModel = new DefaultListModel<>();
        for(MethodNode mn : virtualClass.methods){
            methodModel.addElement(mn.name);
        }
        methods.setModel(methodModel);
    }

    public enum TabMode{
        Opcodes,
        Decompilation,
        Fields,
        Methods;
    }

}
