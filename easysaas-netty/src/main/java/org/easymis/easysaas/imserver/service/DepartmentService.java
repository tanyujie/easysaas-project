package org.easymis.easysaas.imserver.service;

import java.util.List;

import org.easymis.easysaas.imserver.entitys.vo.DepartmentTreeVo;

public interface DepartmentService {
	List<DepartmentTreeVo> getTree(String orgId);
}
