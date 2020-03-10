package org.easymis.easysaas.crm.service;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.dto.CrmForm;

import com.github.pagehelper.PageInfo;

public interface CrmFormService {
	public boolean save(CrmForm bean);

	public boolean update(CrmForm bean);

	public CrmForm findById(String id);

	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);

	public RestResult deleteByIds(String ids);
}
