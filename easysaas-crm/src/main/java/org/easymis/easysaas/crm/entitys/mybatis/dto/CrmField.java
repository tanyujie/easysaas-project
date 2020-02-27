package org.easymis.easysaas.crm.entitys.mybatis.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CrmField implements Serializable {

	private String fieldId;
	// @GenField(labelname="clue/customer/order/common（内置属性使用，自定义为null）",column="table_code",length=64,isnull=true)
	private String tableCode;
	// @GenField(labelname="字段编号",column="field_code",length=64,isnull=true)
	private String fieldCode;
	// @GenField(labelname="字段名称",column="field_name",length=64,isnull=true)
	private String fieldName;
	// @GenField(labelname="字段提示",column="field_tip",length=64,isnull=true)
	private String fieldTip;
	// @GenField(labelname="类型",column="field_type",length=64,isnull=false)
	private String fieldType;
	// @GenField(labelname="是否内置字段",column="inner_default",isnull=false)
	private Boolean innerDefault;
	// @GenField(labelname="启用：on；停用：off",column="state",length=16,isnull=true)
	private String state;
	// @GenField(labelname="创建人",column="create_user_id",length=64,isnull=true)
	private String createUserId;
	// @GenField(labelname="创建时间",column="create_time",isnull=true)
	private Date createTime;
	// @GenField(labelname="修改人",column="update_user_id",length=64,isnull=true)
	private String updateUserId;
	// @GenField(labelname="修改时间",column="update_time",isnull=true)
	private Date updateTime;
	// @GenField(labelname="公司id",column="org_id",length=64,isnull=true)
	private String orgId;

}