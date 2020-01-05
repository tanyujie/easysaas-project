package org.easymis.easycrm.web.utils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MD5Utils {
        protected static final Logger logger = LoggerFactory.getLogger(MD5Utils.class);
        static MessageDigest messageDigest = null;

        /**
         * 判断新密码和旧密码是否正确  返回true 和 false
         *
         * @param newStr
         * @param oldMD5Str
         * @return
         */
        public final static boolean checkMD5(String newStr, String oldMD5Str) {
            String temp = encrypt(newStr);
            return (temp != null && temp.equals(oldMD5Str)) ? true : false;
        }


    public static String encrypt(String password) {
        String passwordMd5 = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(password.getBytes("utf-8"));
            passwordMd5 = toHex(bytes);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return passwordMd5;
    }

    private static String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

     public static void main(String[] args) {
       String pass = "E10ADC3949BA59ABBE56E057F20F883E";
       boolean b = MD5Utils.checkMD5("123456",pass);
         System.out.println(b);
     }
}
