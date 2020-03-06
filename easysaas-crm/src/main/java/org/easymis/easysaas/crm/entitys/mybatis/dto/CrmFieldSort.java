package org.easymis.easysaas.crm.entitys.mybatis.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CrmFieldSort implements Serializable {
	// @GenField(labelname="字段id",column="id",id=true,length=40,isnull=false)
	private String id;
	// @GenField(labelname="",column="org_id",length=40,isnull=true)
	private String orgId;
	// @GenField(labelname="标签 1 线索 2 客户 3 联系人 4 产品 5 商机 6 合同 7回款
	// 8公海",column="label",length=40,isnull=false)
	private String label;
	// @GenField(labelname="字段名称",column="field_name",length=255,isnull=false)
	private String fieldName;
	// @GenField(labelname="字段中文名称",column="name",length=255,isnull=false)
	private String name;
	// @GenField(labelname="字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机 8 文件 9 多选 10
	// 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21
	// 回款计划",column="type",isnull=true)
	private Integer type;
	// @GenField(labelname="字段排序",column="sort",isnull=false)
	private Integer sort;
	// @GenField(labelname="用户id",column="staff_id",isnull=false)
	private Integer staffId;
	// @GenField(labelname="是否隐藏 0、不隐藏 1、隐藏",column="is_hide",isnull=false)
	private Integer isHide;
	// @GenField(labelname="",column="field_id",length=40,isnull=true)
	private String fieldId;

}