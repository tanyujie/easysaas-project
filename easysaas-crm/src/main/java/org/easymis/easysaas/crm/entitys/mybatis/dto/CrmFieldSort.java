package org.easymis.easysaas.crm.entitys.mybatis.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CrmFieldSort implements Serializable {

	private String id;

	private String orgId;

	private String label;

	private String fieldName;

	private String name;
	private Integer type;
	private Integer sort;
	private String staffId;
	private Integer isHide;
	private String fieldId;

}