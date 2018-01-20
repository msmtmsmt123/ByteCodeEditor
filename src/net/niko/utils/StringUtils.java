package net.niko.utils;

import me.lpk.util.AccessHelper;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

public class StringUtils
{

    public static String getMethodFullName(MethodNode mn){

        String str = "<html><font face='consolas' color='blue'>";

        if(AccessHelper.isPrivate(mn.access)){
            str += "private ";
        }else if(AccessHelper.isPublic(mn.access)){
            str += "public ";
        }else if(AccessHelper.isProtected(mn.access)){
            str += "protected ";
        }
        if(AccessHelper.isFinal(mn.access) && AccessHelper.isStatic(mn.access)){
            str += "static final ";
        }else if(AccessHelper.isStatic(mn.access)){
            str += "static ";
        }else if(AccessHelper.isFinal(mn.access)){
            str += "final ";
        }
        str += "</font>";
        str += "<font color='rgb(0,122,255)' face='consolas'><strong>" + getMethodText(mn) + "</strong></font>";

        str += "</font>";

        if(mn.name.equalsIgnoreCase("<init>")){
            return str.replaceAll("void ", "Contructor");
        }

        return str;
    }

    public static String getFieldFullname(FieldNode fn){
        String str = "<html><font face='consolas' color='blue'>";

        if(AccessHelper.isPrivate(fn.access)){
            str += "private ";
        }else if(AccessHelper.isPublic(fn.access)){
            str += "public ";
        }else if(AccessHelper.isProtected(fn.access)){
            str += "protected ";
        }
        if(AccessHelper.isFinal(fn.access) && AccessHelper.isStatic(fn.access)){
            str += "static final ";
        }else if(AccessHelper.isStatic(fn.access)){
            str += "static ";
        }else if(AccessHelper.isFinal(fn.access)){
            str += "final ";
        }
        str += "</font>";
        str += "<font color='rgb(0,122,255)' face='consolas'><strong>" + getFieldText(fn) + "</strong></font>";

        return str;
    }

    public static String getMethodText(MethodNode mn) {
        Type type = Type.getMethodType(mn.desc);
        String str = getFullTypeString(type.getReturnType()) + " ";
        str += mn.name + "(";
        String arguments = "";
        for (int n = 0; n < type.getArgumentTypes().length; n++) {
            arguments += getTypeString(type.getArgumentTypes()[n]);
            if(n < type.getArgumentTypes().length - 1){
                arguments += ", ";
            }
        }
        str += arguments;
        str += ")";
        return str;
    }

    public static String getFieldText(FieldNode fn) {
        Type type = Type.getMethodType(fn.desc);
        String str = getFullTypeString(type.getReturnType()) + " ";
        str += fn.name + ";";
        return str;
    }

    public static String getFullTypeString(Type type){
        if (!type.getDescriptor().contains("(") && (type.getDescriptor().length() == 1 || type.getDescriptor().startsWith("L") || type.getDescriptor().startsWith("["))) {
            if(type.getClassName().contains(".")){
                String[] out = type.getDescriptor().replaceAll(";", "").split("/");
                return out[out.length - 1];
            }
            return type.getClassName();
        }
        String[] str = type.getDescriptor().split("/");
        return str[str.length - 1];
    }

    public static String getTypeString(Type type){
        String str = type.getDescriptor();
        if (!str.contains("(") && (str.length() == 1 || str.startsWith("L") || str.startsWith("["))) {
            str = type.getClassName();
        }
        if (str.contains(".")) {
           str = str.substring(str.lastIndexOf(".") + 1);
        }
        return str.replace(".", "/");
    }

}
