package org.easymis.easysaas.imserver.service;

import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.BackType;

import com.github.pagehelper.PageInfo;

public interface BackTypeService {
	public boolean save(BackType bean);

	public boolean update(BackType bean);

	public BackType findById(String id);

	List findByOrgId(String orgId);

	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);

	public RestResult deleteByIds(String ids);
}
