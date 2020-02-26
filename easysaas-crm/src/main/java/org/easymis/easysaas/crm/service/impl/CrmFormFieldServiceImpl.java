package org.easymis.easysaas.crm.service.impl;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmFormField;
import org.easymis.easysaas.crm.entitys.mybatis.mapper.CrmFormFieldMapper;
import org.easymis.easysaas.crm.service.CrmFormFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

@Service
public class CrmFormFieldServiceImpl implements CrmFormFieldService{
	@Autowired
	private CrmFormFieldMapper mapper;
	@Override
	public boolean save(CrmFormField bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CrmFormField bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CrmFormField findById(String id) {
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
