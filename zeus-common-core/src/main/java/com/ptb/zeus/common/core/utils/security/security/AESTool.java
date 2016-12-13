package com.ptb.zeus.common.core.utils.security.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Project : NettyDemo
 * @Package : com.sondon.NettyDemo
 * @Class : AESTool.java
 * @Company 广州讯动网络科技有限公司
 * @Author : 蔡文锋
 * @DateTime：2015年4月16日 上午9:38:31
 * @Blog：http://blog.csdn.net/caiwenfeng_for_23
 * @Description : { AESTool工具 }
 */
public class AESTool {

	public static String encrypt(String sSrc, Cipher cipher) throws Exception {
		byte[] encrypted = cipher.doFinal(sSrc.getBytes());
		return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
	}

	public static Cipher getEncryptCipher(String sKey) throws Exception {
		if (sKey == null) {
			System.out.print("Key为空null");
			return null;
		}
		// 判断Key是否为16位
		if (sKey.length() != 16) {
			System.out.print("Key长度不是16位");
			return null;
		}
		byte[] raw = sKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
		IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		return cipher;
	}

	public static Cipher getDecryptCipher(String sKey) throws Exception {
		// 判断Key是否正确
		if (sKey == null) {
			System.out.print("Key为空null");
			return null;
		}
		// 判断Key是否为16位
		if (sKey.length() != 16) {
			System.out.print("Key长度不是16位");
			return null;
		}
		byte[] raw = sKey.getBytes("UTF-8");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
		return cipher;
	}


	public static byte[] decrypt(String sSrc, Cipher cipher) throws Exception {
		byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
		byte[] original = cipher.doFinal(encrypted1);
		return original;
	}

	// 加密
	public static String encrypt(String sSrc, String sKey) throws Exception {
		return encrypt(sSrc, getEncryptCipher(sKey));
	}

	// 解密
	public static byte[] decrypt(String sSrc, String sKey) throws Exception {
		return decrypt(sSrc, getDecryptCipher(sKey));
	}

	public static void main(String[] args) throws Exception {
	        /*
	         * 加密用的Key 可以用26个字母和数字组成，最好不要用保留字符，虽然不会错，至于怎么裁决，个人看情况而定
             * 此处使用AES-128-CBC加密模式，key需要为16位。
             */
		String cKey = "1234567890abcdef";
		// 需要加密的字串
		String cSrc = "user＝15063142270,pwd＝110120";
		System.out.println(cSrc);
		// 加密
		Cipher encryptCipher = AESTool.getEncryptCipher(cKey);
		long lStart = System.currentTimeMillis();
		String enString = AESTool.encrypt(cSrc,encryptCipher);

		System.out.println("加密后的字串是：" + enString);

		long lUseTime = System.currentTimeMillis() - lStart;
		System.out.println("加密耗时：" + lUseTime + "毫秒");
		// 解密
		lStart = System.currentTimeMillis();
		String DeString = new String(AESTool.decrypt("etv++JDJX9cLbah7dcqF+9i+kRNzWzV9io+CUy8Tq0U==", cKey));
		System.out.println("解密后的字串是：" + DeString);
		lUseTime = System.currentTimeMillis() - lStart;
		System.out.println("解密耗时：" + lUseTime + "毫秒");
	}
}