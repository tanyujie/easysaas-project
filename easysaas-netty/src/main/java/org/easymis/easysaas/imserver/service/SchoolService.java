package org.easymis.easysaas.imserver.service;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.School;

import com.github.pagehelper.PageInfo;

public interface SchoolService {
	public boolean save(School bean);

	public boolean update(School bean);

	public RestResult deleteByIds(String ids);

	public School findById(String id);

	public School findByOrgId(String orgId);

	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);
}
