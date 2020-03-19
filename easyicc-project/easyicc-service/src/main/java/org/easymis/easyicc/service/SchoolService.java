package org.easymis.easyicc.service;

import org.easymis.easyicc.common.result.RestResult;
import org.easymis.easyicc.domain.entity.School;

import com.github.pagehelper.PageInfo;

public interface SchoolService {
	public boolean save(School bean);

	public boolean update(School bean);

	public RestResult deleteByIds(String ids);

	public School findById(String id);

	public School findByOrgId(String orgId);

	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);
}
