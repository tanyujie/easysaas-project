package org.easymis.easysaas.imserver.service;

import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.VisitorColSelf;

import com.github.pagehelper.PageInfo;

public interface VisitorColSelfService {
	public boolean save(VisitorColSelf bean);

	public boolean update(VisitorColSelf bean);

	public VisitorColSelf findById(String id);

	List findByOrgId(String orgId);

	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);

	public RestResult deleteByIds(String ids);
}
