package org.easymis.easysaas.crm.service;

import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmField;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmFieldSort;
import org.easymis.easysaas.crm.entitys.vo.ColumnHeadVo;

import com.github.pagehelper.PageInfo;


public interface CrmFieldService {
	public boolean save(CrmField bean);

	public boolean update(CrmField bean);

	public CrmField findById(String id);

	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);

	public RestResult deleteByIds(String ids);

	public List<ColumnHeadVo> queryListHead(CrmFieldSort adminFieldSort);

	public RestResult queryFieldConfig(String orgId,String staffId,CrmFieldSort crmFieldSort);

	public RestResult fieldConfig(String orgId,String staffId,CrmFieldSort crmFieldSort);
}
