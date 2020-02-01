package org.easymis.easysaas.open.entitys.vo;

import java.io.Serializable;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class MailHelper implements Serializable {


    // 邮件主题
    private String subject;
    // 邮件的文本内容
    private String content;
    // 邮件附件的文件名
    private Map<String,byte[]> attachFileMap;

    private String toMail;

    private String fromMail;

    /**
     *
     *   发送附件
     *
     * @param sender
     * @param fileType
     * @throws MessagingException
     */

    public void sendAnnexMail(JavaMailSender sender, String fileType) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);  //发送附件 multipart = true
        helper.setFrom(this.fromMail);
        helper.setTo(this.toMail);
        helper.setSubject(this.subject);
        helper.setText(this.content);
        for (String filename : attachFileMap.keySet()) {
            helper.addAttachment(filename, new ByteArrayResource(attachFileMap.get(filename),fileType));
        }
        sender.send(message);
    }
    public void sendAnnexMailV2(JavaMailSender sender, String fileType) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);  //发送附件 multipart = true        
        helper.setFrom("dianjinshou@sharepanzer.com");
        helper.setTo(this.toMail);
        helper.setSubject(this.subject);
        helper.setText(this.content);
        for (String filename : attachFileMap.keySet()) {
            helper.addAttachment(filename, new ByteArrayResource(attachFileMap.get(filename),fileType));
        }
        sender.send(message);
    }

}
