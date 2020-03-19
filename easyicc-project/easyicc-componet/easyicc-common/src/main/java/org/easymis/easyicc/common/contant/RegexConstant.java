package org.easymis.easyicc.common.contant;

/**
 *
 *  常用的正则表达式
 */
public class RegexConstant {


    //手机号码正则
    public final static String regexp_phoneNumber = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";

    /**
     * 邮箱正则
     */
    public static final String regexp_email = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
}
