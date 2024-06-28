package com.example.ctsjmain.util;

public class StringUtil {

    public static boolean isNotNull(String str){
        if (null != str && !" ".equals(str)) {
            return true;
        }
        return false;
    }
    public static boolean isNull(String... params) {
        if (null == params || params.length == 0) {
            return true;
        }
        for (String s : params) {
            if (null != s && !"".equals(s)) {
                return false;
            }
        }
        return  true;
    }
}
