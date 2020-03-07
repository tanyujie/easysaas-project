package org.easymis.easysaas.imserver.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5Utils {
    public static String getMD5Str(String strValue) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String newStr = Base64.getEncoder().encodeToString(md5.digest(strValue.getBytes()));
        return newStr;
    }

    public static void main(String[] args) {
        try {
            String md5 = getMD5Str("imooc");
            System.out.println(md5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
