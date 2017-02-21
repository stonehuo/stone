package com.kpap.basis.util;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * MD5加密工具类<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-16 下午12:39:11
 */
public class MD5Util {
	
	private static final Logger logger = LoggerFactory.getLogger(MD5Util.class);
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
		"e", "f" };
	
	/**
	 * 对字符串签名
	 * 
	 * @param signStr
	 * @return
	 */
	public static String md5Sign(String signStr) {
		byte[] signInfo = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			signInfo = md.digest(signStr.getBytes("UTF-8"));
			return byteArrayToHexString(signInfo).toUpperCase();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n += 256;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

}
