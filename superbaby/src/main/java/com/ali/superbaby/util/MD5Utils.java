package com.ali.superbaby.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 使用MD5加密
 */
public class MD5Utils {

    public static String encodeByMD5(String password){
        byte[] newPasswordArray = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(password.getBytes());
            String result = "";
            for(byte b : bytes)
            {
                String temp = Integer.toHexString(b & 0xff);
                if(temp.length() == 1)
                {
                    temp = "0" + temp;
                }
                result = result + temp;
            }
            return result;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }


}
