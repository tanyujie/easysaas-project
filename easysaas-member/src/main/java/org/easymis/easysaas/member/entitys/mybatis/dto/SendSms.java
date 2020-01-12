package org.easymis.easysaas.member.entitys.mybatis.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SendSms {
	private String id;
	private String mobile;
	private LocalDateTime sendTime;
	private Integer sendType;
	private String code;

}
