package org.easymis.easyicc.common.utils;


import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * 微信 ,支付宝  工具类
 */
@Slf4j
public class PayUtils {

    /**
     * 金额分转元
     * 注意:如果传入的参数中含小数点,则直接原样返回
     * 该方法返回的金额字符串格式为<code>00.00</code>,其整数位有且至少有一个,小数位有且长度固定为2
     *
     * @param fee 金额的分进制字符串
     * @return String 金额的元进制字符串
     */
    public static String moneyFenToYuan(Integer fee) {
        if (fee == null) {
            return "0.00";
        }
        char[] amountChar = Integer.toString(fee).toCharArray();
        if (amountChar.length == 1) {
            return new StringBuilder("0.0").append(amountChar).toString();
        } else if (amountChar.length == 2) {
            return new StringBuilder("0.").append(amountChar).toString();
        } else {
            char[] amountChar1 = new char[amountChar.length + 1];
            for (int i = 0; i < amountChar.length; i++) {
                amountChar1[i] = amountChar[i];
            }
            amountChar1[amountChar1.length - 1] = amountChar[amountChar.length - 1];
            amountChar1[amountChar1.length - 2] = amountChar[amountChar.length - 2];
            amountChar1[amountChar1.length - 3] = '.';
            return new String(amountChar1);
        }
    }

    public static Integer moneyYuanToFen(BigDecimal decimal) {
        if (decimal == null) {
            return 0;
        } else {
            char[] chars = decimal.setScale(2, BigDecimal.ROUND_DOWN).toString().toCharArray();
            char[] chars1 = new char[chars.length - 1];
            int index = 0;

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '.') {
                    index++;
                    continue;
                }
                chars1[i - index] = chars[i];
            }
            return Integer.valueOf(new String(chars1));
        }
    }

    /**
     * 创建随机数
     *
     * @param
     * @return
     */
    public static String generateNoncestr() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        char[] res = new char[16];
        for (int i = 0; i < 16; i++) {
            Random rd = new Random();
            res[i] = chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return new String(res);
    }

    /**
     *
     *
     *  创建随机数
     * @return
     */

    public static String generateNoncestr(Integer length ) {
        String chars = "0123456789";
        char[] res = new char[length];
        for (int i = 0; i < length; i++) {
            Random rd = new Random();
            res[i] = chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return new String(res);
    }


    /**
     * @param bean
     * @Author
     * @Version 1.0
     * @Description 微信支付签名
     * @Return java.lang.String
     * @Exception
     * @Date 2019/6/4
     */
    public static <T> String generateSignByBean(T bean, String payKey) {
        Map<String, Object> requestMap = new ObjDict<>(bean.getClass()).conversion(bean);
        List<String> keyList = requestMap.keySet().stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        keyList.forEach(key ->
        {
            String value = requestMap.get(key).toString();
            builder.append(key).append("=").append(value).append("&");
        });
        String originalSign = builder.append("key=").append(payKey).toString();
        //String originalSign = builder.substring(0, builder.length() - 1);
        log.info("original sign ->{}", originalSign);
        return MD5Util.MD5Encode(originalSign, "utf-8").toUpperCase();
    
    }

    /**
     * @param prepayment,paykey
     * @Author
     * @Version 1.0
     * @Description Prepayment生成sign
     * @Return java.lang.String
     * @Exception
     * @Date 2019/6/5
     */
    public static <T> String generateSignByPrepayment(T prepayment, String payKey) {

        Map<String, Object> requestMap = new ObjDict<>(prepayment.getClass()).conversion(prepayment);
        requestMap.put("package", "Sign=WXPay");
        List<String> keyList = requestMap.keySet().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        keyList.forEach(key -> {
            String value = requestMap.get(key).toString();
            builder.append(key).append("=").append(value).append("&");
        });
        String originalSign = builder.append("key=").append(payKey).toString();
        log.info("original sign ->{}", originalSign);
        return MD5Util.MD5Encode(originalSign, "utf-8").toUpperCase();
    }








    public static String formatAmount(BigDecimal decimal) {
        return Objects.isNull(decimal) ? null : decimal.setScale(2, BigDecimal.ROUND_DOWN).toString();
    }






}
