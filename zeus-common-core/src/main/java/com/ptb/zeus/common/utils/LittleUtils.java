package com.ptb.zeus.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 * Created by MyThinkpad on 2016/6/29.
 */
public class LittleUtils {

    public final static String DEFAULT_IMG_TYPE = "png";

    public static String getImgType(InputStream inputStream){
        String type = DEFAULT_IMG_TYPE;
        ImageInputStream iis = null;
        try {
            iis = ImageIO.createImageInputStream(inputStream);
            Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
            if (iter.hasNext()) {
                type = iter.next().getFormatName().trim();;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null != iis)
                    iis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return type;
    }

    public static int strLength1(String s) {
        int valueLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, i + 1);
            if (temp.matches(chinese))
                valueLength += 2;
            else
                valueLength += 1;
        }
        return  valueLength;
    }

    public static int strLength2(String s) {
        if (s == null)
            return 0;
        int k = 0x80;
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;
            if (!(c[i] / k == 0)) {
                len++;
            }
        }
        return len;
    }

    /****
     * 由于Java是基于Unicode编码的，因此，一个汉字的长度为1，而不是2。
     * 但有时需要以字节单位获得字符串的长度。例如，“123abc长城”按字节长度计算是10，而按Unicode计算长度是8。
     * 为了获得10，需要从头扫描根据字符的Ascii来获得具体的长度。如果是标准的字符，Ascii的范围是0至255，如果是汉字或其他全角字符，Ascii会大于255。
     * 因此，可以编写如下的方法来获得以字节为单位的字符串长度。
     ***/
    public static int strLength3(String s) {
        int length = 0;
        for(int i = 0; i < s.length(); i++) {
            int ascii = Character.codePointAt(s, i);
            if(ascii >= 0 && ascii <=255)
                length++;
            else
                length += 2;
        }
        return length;
    }

    /**
     * 基本原理是将字符串中所有的非标准字符（双字节字符）替换成两个标准字符（**，或其他的也可以）。这样就可以直接例用length方法获得字符串的字节长度了
     * * */
    public static int strLength4(String s) {
        s = s.replaceAll("[^\\x00-\\xff]", "**");
        int length = s.length();
        return length;
    }


    public static String getPargramUrl(String url, String seg){
        StringTokenizer st = null;
        try {
            st = new StringTokenizer(new URL(url).getQuery(), "&");
            while (st.hasMoreTokens()) {
                String pairs = st.nextToken();
                String key = pairs.substring(0, pairs.indexOf('='));
                String value = pairs.substring(pairs.indexOf('=') + 1);
                if(key.equals(seg.trim()))
                    return value;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
