package org.easymis.easysaas.crm.service;

import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.dto.Department;

import com.github.pagehelper.Page;

public interface DepartmentService {
	List getPage(Page page, Department bean);

	List getList(Department bean);

	Department findById(String departmentId);

	void delete(String departmentId);

	RestResult save(Department bean);

	RestResult update(Department bean);

}
