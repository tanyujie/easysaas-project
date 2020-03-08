package org.easymis.easysaas.crm.service.impl;

import java.util.UUID;

import org.easymis.easysaas.crm.common.ScanEnum;
import org.easymis.easysaas.crm.entitys.mybatis.dto.Member;
import org.easymis.easysaas.crm.entitys.vo.LoginQrCode;
import org.easymis.easysaas.crm.service.QrCodeLoginService;
import org.easymis.easysaas.crm.utils.QrCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.cache.Cache;

import lombok.extern.slf4j.Slf4j;

/**
 * 二维码登录相关service实现类
 *
 * @author wangkai  2019/7/20
 */
@Slf4j
@Service
public class QrCodeLoginServiceImpl implements QrCodeLoginService {

    @Autowired
    Cache<String, Member> qrCodeLoginCache;

    @Override
    public LoginQrCode generateQrCode() {
        String uuid = UUID.randomUUID().toString();
        String url = "http://192.168.1.4/mobile/index?token=" + uuid;
        String qrCode = QrCodeUtil.toBase64(url, 280, 280);
        LoginQrCode result = LoginQrCode.builder().token(uuid).image(qrCode).build();
        qrCodeLoginCache.put(uuid, new Member());
        return result;
    }

    @Override
    public Member getScanStatus(String token) {

        return qrCodeLoginCache.getIfPresent(token);
    }

    @Override
    public void scanOk(String token, String phoneNumber) {
    	Member person = qrCodeLoginCache.getIfPresent(token);
        if (person != null) {
            person.setPhoneNumber(phoneNumber);
            person.setScan(ScanEnum.WAIT_LOGIN);
        }
    }

    @Override
    public boolean qrLogin(String token, String userName) {
    	Member person = qrCodeLoginCache.getIfPresent(token);
        if (person != null) {
            person.setScan(ScanEnum.LOGIN);
            person.setPhoneNumber(userName);
            return true;
        }
        return false;
    }

    @Override
    public void cancelLogin(String token) {
        qrCodeLoginCache.invalidate(token);
    }
}
