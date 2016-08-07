package com.ptb.zeus.common.utils;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PinyinApi {
    /**
     * 提取每个汉字的首字母(大写)
     *
     * @param str
     * @return
     */
    public static Character getPinYinHeadChar(String str) {
        if (isNull(str)) {
            return '#';
        }
        char word = str.charAt(0);
        // 提取汉字的首字母
        String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
        if (pinyinArray != null) {
            return (char)(pinyinArray[0].charAt(0) - 32);
        }else if(word <= 'z' && word >= 'a'){
            return (char)(word - 32);
        }else if(word <= 'Z' && word >= 'A'){
            return word;
        }else{
            return '#';
        }
    }

    /*
    * 判断字符串是否为空
    */

    public static boolean isNull(Object strData) {
        if (strData == null || String.valueOf(strData).trim().equals("")) {
            return true;
        }
        return false;
    }

    /**
     * 去掉字符串包含的所有空格
     *
     * @param value
     * @return
     */
    public static String string2AllTrim(String value) {
        if (isNull(value)) {
            return "";
        }
        return value.trim().replace(" ", "");
    }

    public static Map<Character, Set<String>> initialsIndex(){
        Map<Character, Set<String>> map = new HashMap<Character, Set<String>>();
        for(char a = 'Z'; a >= 'A'; a--){
            map.put(a, new HashSet<String>());
        }
        map.put('#', new HashSet<String>());
        return map;
    }


    public static void main(String[] args) {
        long sTime = System.currentTimeMillis();
        String ss = "中国";
        String dd = "Z";
        System.out.println(getPinYinHeadChar(ss));
        System.out.println(getPinYinHeadChar(dd));
        System.out.println("中".length() + " " + "z".length());
    }
}
