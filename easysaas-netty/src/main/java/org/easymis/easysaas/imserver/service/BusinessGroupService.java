package org.easymis.easysaas.imserver.service;

import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.BusinessGroup;

import com.github.pagehelper.PageInfo;

public interface BusinessGroupService {
	public boolean save(BusinessGroup bean);

	public boolean update(BusinessGroup bean);

	public BusinessGroup findById(String id);

	List findByOrgId(String orgId);

	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);

	public RestResult deleteByIds(String ids);
}