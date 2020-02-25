package org.easymis.easysaas.crm.service;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmField;

import com.github.pagehelper.PageInfo;


public interface CrmFieldService {
	public boolean save(CrmField bean);

	public boolean update(CrmField bean);

	public CrmField findById(String id);

	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);

	public RestResult deleteByIds(String ids);
}
