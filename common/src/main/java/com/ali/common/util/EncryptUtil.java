package com.ali.common.util;

import java.security.MessageDigest;

/**
 * 加密认证工具
 *
 * @author simon
 */
public class EncryptUtil {

    /**
     * 加密算法
     */
    private static final String ALGORITHM = "MD5";
    /**
     * 十六显进制数组
     */
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * encode string
     *
     * @param algorithm
     * @param str
     * @return String
     */
    public static String encode(String algorithm, String str) {

        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * encode By MD5
     *
     * @param str
     * @return String
     */
    public static String encodeByMD5(String str) {

        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Takes the raw bytes from the digest and formats them correct.
     *
     * @param bytes the raw bytes from the digest.
     * @return the formatted bytes.
     */
    private static String getFormattedText(byte[] bytes) {

        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] << 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    public static String getPassword(String password, String salt) {
        String passwordMD5 = EncryptUtil.encodeByMD5(password);
        String password_salt = EncryptUtil.encodeByMD5(passwordMD5 + salt);
        return password_salt;
    }

    public static void main(String[] args) {

        System.out.println(getPassword("123123123", "15757676090"));
    }


}
