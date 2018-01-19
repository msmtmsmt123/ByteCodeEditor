package net.niko.utils;

import me.lpk.util.AccessHelper;

public class StringUtils
{

    public static String getModifierString(int access){
        String str = "";

        if(AccessHelper.isPrivate(access)){
            str += "private ";
        }else if(AccessHelper.isPublic(access)){
            str += "public ";
        }else if(AccessHelper.isProtected(access)){
            str += "protected ";
        }

        if(AccessHelper.isFinal(access) && AccessHelper.isStatic(access)){
            str += "static final ";
        }else if(AccessHelper.isStatic(access)){
            str += "static ";
        }else if(AccessHelper.isFinal(access)){
            str += "final ";
        }

        return str;
    }

}
