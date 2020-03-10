package org.easymis.easysaas.crm.service;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.dto.CrmFormField;

import com.github.pagehelper.PageInfo;

public interface CrmFormFieldService {
	public boolean save(CrmFormField bean);

	public boolean update(CrmFormField bean);

	public CrmFormField findById(String id);

	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);

	public RestResult deleteByIds(String ids);
}
