package org.easymis.easysaas.crm.controller;

import org.easymis.easysaas.crm.entitys.dto.Member;
import org.easymis.easysaas.crm.service.QrCodeLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

/**
 * 二维码登录相关接口
 *
 * @author wangkai  2019/7/20
 */
@RestController
@RequestMapping("/qrcode")
public class QrCodeLoginController {

    @Autowired
    QrCodeLoginService qrCodeLoginService;

    @GetMapping
    public String getQrCode(){
        JSONObject result = new JSONObject();
        result.put("status",true);
        result.put("data",qrCodeLoginService.generateQrCode());

        return result.toJSONString();
    }

    @GetMapping(value = "/scan/loop")
    public String scan(@RequestParam String token){

        JSONObject result = new JSONObject();
        result.put("status",true);

        Member member = qrCodeLoginService.getScanStatus(token);
        if (member == null) {
            // 过期
            result.put("type",0);
        }else{
            // 已经扫描
            result.put("type",member.getScan().getType());
            result.put("userName",member.getPhoneNumber());
        }

        return result.toJSONString();
    }

    /**
     * 成功扫描
     */
    @PostMapping(value = "/scan/ok")
    public String scanOk(@RequestParam String token,@RequestParam String userName){

        qrCodeLoginService.scanOk(token,userName);

        JSONObject result = new JSONObject();
        result.put("status",true);
        return result.toJSONString();
    }

    /**
     * 确认登陆
     */
    @PostMapping(value = "/scan/login/{token}")
    public String scanLogin(@PathVariable String token,@RequestParam String userName){
        JSONObject result = new JSONObject();
        result.put("status",qrCodeLoginService.qrLogin(token, userName));
        return result.toJSONString();
    }

    /**
     * 取消登录
     */
    @PostMapping(value = "/scan/cancel/{token}")
    public String cancelLogin(@PathVariable String token){

        qrCodeLoginService.cancelLogin(token);

        JSONObject result = new JSONObject();
        result.put("status",true);
        return result.toJSONString();
    }
}
