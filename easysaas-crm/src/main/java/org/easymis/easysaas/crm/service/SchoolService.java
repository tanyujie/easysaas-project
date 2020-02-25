package org.easymis.easysaas.crm.service;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.School;

import com.github.pagehelper.PageInfo;

public interface SchoolService {
	public boolean save(School bean);

	public boolean update(School bean);

	public School findById(String id);

	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);

	public RestResult deleteByIds(String ids);
}
