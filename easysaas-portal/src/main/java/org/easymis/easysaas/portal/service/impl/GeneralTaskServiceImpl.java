package org.easymis.easysaas.portal.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.easymis.easysaas.portal.entitys.vo.MailHelper;
import org.easymis.easysaas.portal.service.GeneralTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class GeneralTaskServiceImpl implements GeneralTaskService {
    @Value("${spring.mail.fromMail}")
    private String fromMail;
    @Autowired
    JavaMailSender javaMailSender;
    
	@Override
	public void sendEmailAsyncExecutor(byte[] bytes, String toMail) {
        Map<String, byte[]> attachFileMap = new HashMap<>();
        attachFileMap.put("企业公示信息-威客智库.xlsx",bytes );

        MailHelper mailHelper = new MailHelper().setToMail(toMail).setSubject("威客智库-企业公示信息导出结果").setAttachFileMap(attachFileMap).setContent("").setFromMail(fromMail);
        try {
            mailHelper.sendAnnexMail(javaMailSender, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        } catch (MessagingException e) {
            log.error("邮件发送失败 toMail={} ->",toMail,e);
        }

	}

}
