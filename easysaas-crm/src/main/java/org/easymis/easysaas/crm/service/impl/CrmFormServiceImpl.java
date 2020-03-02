package org.easymis.easysaas.crm.service.impl;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmForm;
import org.easymis.easysaas.crm.entitys.mybatis.mapper.CrmFormMapper;
import org.easymis.easysaas.crm.service.CrmFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

@Service
public class CrmFormServiceImpl implements CrmFormService{
	@Autowired
	private CrmFormMapper mapper;
	@Override
	public boolean save(CrmForm bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CrmForm bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CrmForm findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult deleteByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
