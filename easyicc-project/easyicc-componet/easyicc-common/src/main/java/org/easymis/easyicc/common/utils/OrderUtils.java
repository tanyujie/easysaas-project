package org.easymis.easyicc.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderUtils {
    /**
     * @param
     * @Author
     * @Version 1.0
     * @Description 生成订单号  最大32位  当前27位
     * @Return java.lang.String
     * @Exception
     * @Date 2019/6/5
     */
    public static String generateOrderNo(String prefix) {

        String dateform = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());  //14位
        // String threadName =Thread.currentThread().getName();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        char[] res = new char[10];
        for (int i = 0; i < 10; i++) {
            Random rd = new Random();
            res[i] = chars.charAt(rd.nextInt(chars.length() - 1));
        }

        return new StringBuilder(prefix).append(dateform).append(res).toString();
    }


}
