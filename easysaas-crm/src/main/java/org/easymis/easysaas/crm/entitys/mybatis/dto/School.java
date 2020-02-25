package org.easymis.easysaas.crm.entitys.mybatis.dto;

import lombok.Data;

@Data
public class School {
	private String schoolId;
	private String orgId;
	private String name;
	private String schoolType;
	private String provinceId;
	private String cityId;
	private String districtId;
	private String addressDetail;
	private String contact;
	private String contactBackup;

}
