package org.easymis.easyicc.common.utils;

import java.util.Random;

/**
 * 接口 key 和 secret key 生成工具类
 */
public class ApiKeyGenerator {

    public static char[] pool = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'q', 'w', 't', 'y', 'u', 'i', 'o', 'p', 'z'
            , 'x', 'c', 'v', 'b', 'n', 'm'};

    /**
     * @param
     * @Author
     * @Version 1.0
     * @Description 生成key  16位
     * @Return java.lang.String
     * @Exception
     * @Date 2019/8/20
     */

    public static String generatePublicKey() {
        char[] chars = new char[16];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = pool[new Random().nextInt(pool.length-1) + 1];
        }
        return new String(chars);
    }
    /**
     * @Author
     * @Version  1.0
     * @Description  生成 secret key 32位 大写
     * @param
     * @Return java.lang.String
     * @Exception
     * @Date 2019/8/20
     */
    public static String generateSecretKey(){
        char[] chars = new char[32];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = pool[new Random().nextInt(pool.length-1) + 1];
        }
        return new String(chars).toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(generateSecretKey());
    }

}
