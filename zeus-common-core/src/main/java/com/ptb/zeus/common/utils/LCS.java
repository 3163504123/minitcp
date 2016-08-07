package com.ptb.zeus.common.utils;

/**
 * Created by eric on 16/2/25.
 */
public class LCS {
    public static String longestCommonSubsequence(String s1, String s2) {
        int[][] num = new int[s1.length() + 1][s2.length() + 1];

        /***
         * 计算LCS长度
         */
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    num[i][j] = 1 + num[i - 1][j - 1];
                } else {
                    num[i][j] = Math.max(num[i - 1][j], num[i][j - 1]);
                }
            }
        }

/*        *//***
         * 打印
         *//*
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                System.out.print(String.format("%d ", num[i][j]));
            }
            System.out.println();
        }*/


        /***
         * 输出LCS字符串
         */
        int s1Pos = s1.length();
        int s2Pos = s2.length();
        StringBuilder ret = new StringBuilder();
        while (s1Pos != 0 && s2Pos != 0) {
            if (s1.charAt(s1Pos - 1) == s2.charAt(s2Pos - 1)) {
                ret.append((s1.charAt(s1Pos - 1)));
                s1Pos--;
                s2Pos--;
            } else if (num[s1Pos][s2Pos - 1] > num[s1Pos - 1][s2Pos]) {
                s2Pos--;
            } else {
                s1Pos--;
            }
        }
        return ret.reverse().toString();
    }



    public static int sim(String a, String b) {
        String lcs = longestCommonSubsequence(a,b);
        return lcs.length() - (a.length() + b.length())/Math.min(a.length(),b.length());

    }

}
