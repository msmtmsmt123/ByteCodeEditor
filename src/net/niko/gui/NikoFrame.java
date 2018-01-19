package net.niko.gui;

import lombok.Getter;
import me.lpk.util.OpUtils;
import net.niko.classld.VirtualClass;
import net.niko.utils.StringUtils;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class NikoFrame
{

    private JList<String> opcodes;
    private JList<String> fields;
    private JList<String> methods;

    public JTabbedPane createPane(){
        JTabbedPane tabbedPane = new JTabbedPane();

        opcodes = new JList<>();
        fields = new JList<>();
        methods = new JList<>();

        tabbedPane.addTab(TabMode.Opcodes.name(), opcodes);
        tabbedPane.addTab(TabMode.Decompilation.name(), null);
        tabbedPane.addTab(TabMode.Fields.name(), fields);
        tabbedPane.addTab(TabMode.Methods.name(), methods);

        return tabbedPane;
    }

    public void update(VirtualClass virtualClass){
        DefaultListModel<String> opcodeModel = new DefaultListModel<>();
        for(MethodNode mn : virtualClass.methods){
            for(AbstractInsnNode abstractInsnNode : mn.instructions.toArray()){
                opcodeModel.addElement(OpUtils.toString(abstractInsnNode));
            }
        }
        opcodes.setModel(opcodeModel);

        DefaultListModel<String> fieldModel = new DefaultListModel<>();
        for(FieldNode fn : virtualClass.fields){
            fieldModel.addElement(StringUtils.getModifierString(fn.access) + fn.name + ";");
        }
        fields.setModel(fieldModel);

        DefaultListModel<String> methodModel = new DefaultListModel<>();
        for(MethodNode mn : virtualClass.methods){
            methodModel.addElement(StringUtils.getModifierString(mn.access) + mn.name + ";");
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
