package org.easymis.easysaas.gateway.entitys.mybatis.dto;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SendSms {
	private String id;
	private String mobile;
	private Date sendTime;
	private Integer sendType;
	private String code;

}