package org.easymis.easyicc.domain.entity;

import java.io.Serializable;

import lombok.Data;
@Data
public class Department implements Serializable {

	private String id;
	//@GenField(labelname = "组织id", column = "org_id", length = 40, isnull = false)
	private String orgId;
	//@GenField(labelname = "部门名称", column = "name", length = 255, isnull = false)
	private String name;
	//@GenField(labelname = "部门编号", column = "no", length = 40, isnull = true)
	private String no;
	//@GenField(labelname = "部门负责人", column = "leader_id", length = 40, isnull = true)
	private String leaderId;
	//@GenField(labelname = "副职id|最多6个副职", column = "assist_id", length = 300, isnull = true)
	private String assistId;
	//@GenField(labelname = "可见id", column = "invisible_ids", length = 255, isnull = true)
	private String invisibleIds;
	//@GenField(labelname = "上级部门", column = "parent_id", length = 40, isnull = true)
	private String parentId;
	//@GenField(labelname = "排序|显示顺序", column = "priority", length = 255, isnull = true)
	private Integer priority;
	//@GenField(labelname = "级别", column = "level", length = 255, isnull = true)
	private Integer level;
	//@GenField(labelname = "是否末级部门1是0否", column = "is_leaf", isnull = true)
	private Boolean isLeaf;
	//@GenField(labelname = "部门描述", column = "depict", length = 255, isnull = true)
	private String depict;
	//@GenField(labelname = "启用状态1启用2停用", column = "status", isnull = true)
	private Integer status;
}
