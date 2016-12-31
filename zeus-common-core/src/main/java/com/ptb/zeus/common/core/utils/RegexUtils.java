package com.ptb.zeus.common.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    public RegexUtils() {
    }

    public static String sub(String regex, String source, int index) {
        Pattern pattern = Pattern.compile(regex);
        return extract(pattern, source, index);
    }

    private static String extract(Pattern pattern, String source, int index) {
        if(index < 0) {
            return null;
        } else {
            Matcher matcher = pattern.matcher(source);
            return matcher.find() && matcher.groupCount() >= index + 1?matcher.group(index + 1):null;
        }
    }
}