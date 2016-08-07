package com.ptb.zeus.common.utils;


import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.Base64;

public class PasswordHelper {

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private static String algorithmName = "md5";
    private static final int hashIterations = 1;

    public static String encryptPassword(String password) {


        String newPassword = new SimpleHash(
                algorithmName,
                password, null,
                hashIterations).toHex();

        return newPassword;
    }

    public static String encodeByDes(String source) {
        return Base64.getUrlEncoder().encodeToString(DES.encrypt(source.getBytes(), "123456789ptb987654321"));
    }


    public static String decodeByDes(String source) throws Exception {
        byte[] decrypt = DES.decrypt(Base64.getUrlDecoder().decode(source), "123456789ptb987654321");
        return new String(decrypt);
    }
}