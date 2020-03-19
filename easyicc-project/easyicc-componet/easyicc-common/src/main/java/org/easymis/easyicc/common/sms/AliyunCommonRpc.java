package org.easymis.easyicc.common.sms;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

/**
　* @description: 发送短信工具类
　* author zh
　* @date 2019/7/9 17:34
　*/
@Slf4j
public class AliyunCommonRpc {

    private final static DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIPR36p4xDuayC", "ZyDz9R8AhmNkHf4jpiJ34yMLJiJZHY");

    /**
 　　* @description: 发送验证码通知
 　　* author zh
 　　* @date 2019/7/9 19:34
 　　*/
    public static AliyunSmsResult sendSms(String mobile, String code) {
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "黄金眼");
        request.putQueryParameter("TemplateCode", "SMS_164275292");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        return commonResult(request);
    }
    /**
 　　* @description: 抽取的公共代码
 　　* author zh
 　　* @date 2019/7/9 19:45
 　　*/
    private static AliyunSmsResult commonResult(CommonRequest request){
        IAcsClient client = new DefaultAcsClient(profile);
        AliyunSmsResult result = new AliyunSmsResult();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        try {
            CommonResponse response = client.getCommonResponse(request);
            int httpStatus = response.getHttpStatus();
            log.info("aliyun短信发送返回httpStatus{},data:{}", httpStatus, response.getData());
            if (httpStatus == HttpStatus.SC_OK) {
                result = JSON.parseObject(response.getData(), AliyunSmsResult.class);
            } else {

            }
        } catch (ServerException e) {
            log.error("aliyun短信发送失败-->", e);
        } catch (ClientException e) {
            log.error("aliyun短信发送失败-->", e);
        }
        return result;
    }



    public static void main(String[] args) {
        AliyunCommonRpc.sendSms("13551259347","234234");
//       // AliyunCommonRpc.sendStaffOrAgentAccountSms("13522090861","山东经销商","开通","PZ003","123456");
////        AliyunCommonRpc.sendAccountDisableSms("13522090861","Test1","zh17286540@163.com");
////        AliyunCommonRpc.sendAccountOpenSms("13522090861","Test2","123456");
////        AliyunCommonRpc.sendAccountRecoverySms("13522090861","Test3");
////        AliyunCommonRpc.sendAccountUpdateSms("13522090861","Test4","123456");
////        AliyunCommonRpc.sendSettleSendSms("13522090861","2019年7月");
    }


}
