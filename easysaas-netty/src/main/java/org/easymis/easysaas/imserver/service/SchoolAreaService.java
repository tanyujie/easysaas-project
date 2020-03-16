package org.easymis.easysaas.imserver.service;

import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.SchoolArea;

import com.github.pagehelper.PageInfo;

public interface SchoolAreaService {
	public boolean save(SchoolArea bean);

	public boolean update(SchoolArea bean);

	public SchoolArea findById(String id);
	public List findByOrgId(String orgId);
	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);

	public RestResult deleteByIds(String ids);
}
