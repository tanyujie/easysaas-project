package org.easymis.easysaas.crm.service.impl;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmField;
import org.easymis.easysaas.crm.service.CrmFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

@Service
public class CrmFieldServiceImpl implements CrmFieldService{
	@Autowired
	private CrmFieldMapper mapper;
	@Override
	public boolean save(CrmField bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CrmField bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CrmField findById(String id) {
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
