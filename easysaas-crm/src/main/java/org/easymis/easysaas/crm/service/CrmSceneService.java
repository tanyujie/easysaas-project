package org.easymis.easysaas.crm.service;

import org.easymis.easysaas.common.parameter.BasePageRequest;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.dto.CrmScene;
import org.easymis.easysaas.crm.entitys.dto.School;

import com.github.pagehelper.PageInfo;

public interface CrmSceneService {
	public boolean save(CrmScene bean);

	public boolean update(CrmScene bean);

	public School findById(String id);

	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);

	public RestResult deleteByIds(String ids);
	public RestResult filterConditionAndGetPageList(BasePageRequest basePageRequest);
}
