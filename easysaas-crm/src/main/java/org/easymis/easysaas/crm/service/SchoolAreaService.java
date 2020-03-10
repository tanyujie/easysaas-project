package org.easymis.easysaas.crm.service;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.dto.SchoolArea;

import com.github.pagehelper.PageInfo;

public interface SchoolAreaService {
	public boolean save(SchoolArea bean);

	public boolean update(SchoolArea bean);

	public SchoolArea findById(String id);

	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);

	public RestResult deleteByIds(String ids);
}
