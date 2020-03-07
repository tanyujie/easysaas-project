package org.easymis.easysaas.imserver.entitys.mybatis.dto;

import java.util.Date;

import lombok.Data;
@Data
public class ChatMsg {

	private String id;

	private String sendUserId;

	private String acceptUserId;

	private String msg;

	private Integer signFlag;

	private Date createTime;
}
