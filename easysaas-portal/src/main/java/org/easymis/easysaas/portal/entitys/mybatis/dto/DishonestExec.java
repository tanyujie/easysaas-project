package org.easymis.easysaas.portal.entitys.mybatis.dto;

import lombok.Data;

@Data
public class DishonestExec {
	private String id;
	private String dishonestId;
	private String execId;
	private String execType;
	private String name;
	private String sex;
	private String caseCode;
	private String execCourtName;
	private String publishDate;
}
