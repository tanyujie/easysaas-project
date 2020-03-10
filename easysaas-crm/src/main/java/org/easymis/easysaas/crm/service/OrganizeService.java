package org.easymis.easysaas.crm.service;

import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.dto.Department;
import org.easymis.easysaas.crm.entitys.dto.Organize;

import com.github.pagehelper.Page;

public interface OrganizeService {
	List getPage(Page page, Organize bean);

	List getList(Organize bean);

	Department findById(String departmentId);

	void delete(String departmentId);

	RestResult save(Organize bean);

	RestResult update(Organize bean);

}
