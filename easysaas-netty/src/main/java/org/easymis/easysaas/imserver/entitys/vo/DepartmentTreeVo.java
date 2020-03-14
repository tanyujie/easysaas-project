package org.easymis.easysaas.imserver.entitys.vo;

import java.util.List;

import lombok.Data;
@Data
public class DepartmentTreeVo {
	private String id;
	private String name;
	private String parentId;
	private Integer level;
	private Boolean isLeaf;
	private List<DepartmentTreeVo> departmentList;
	private List<StaffInfoVo> staffList;
}
