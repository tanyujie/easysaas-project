package org.easymis.easyicc.common.sms;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by leo on 2019/2/18.
 */
@Slf4j
public class SmsUtil {



    /**
     * 创建验证码
     */
    public static String smsCode() {
        String random = (int) ((Math.random() * 9 + 1) * 100000) + "";
        return random;
    }



}
