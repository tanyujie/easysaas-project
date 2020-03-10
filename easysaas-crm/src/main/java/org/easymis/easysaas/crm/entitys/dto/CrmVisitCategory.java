package org.easymis.easysaas.crm.entitys.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CrmVisitCategory implements Serializable {
	// @GenField(labelname="主题",column="category_id",id=true,length=20,isnull=false)
	private String categoryId;
	// @GenField(labelname="",column="depict",length=255,isnull=true)
	private String depict;
	// @GenField(labelname="",column="org_id",length=20,isnull=false)
	private String orgId;
	// @GenField(labelname="",column="priority",length=255,isnull=true)
	private String priority;
	// @GenField(labelname="状态0未启用1启用",column="status",isnull=true)
	private Integer status;
	// @GenField(labelname="",column="subject_name",length=255,isnull=true)
	private String categoryName;

}