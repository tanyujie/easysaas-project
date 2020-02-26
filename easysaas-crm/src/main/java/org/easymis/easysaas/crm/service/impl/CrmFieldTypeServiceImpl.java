package org.easymis.easysaas.crm.service.impl;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmFieldType;
import org.easymis.easysaas.crm.entitys.mybatis.mapper.CrmFieldTypeMapper;
import org.easymis.easysaas.crm.service.CrmFieldTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrmFieldTypeServiceImpl implements CrmFieldTypeService{
	@Autowired
	private CrmFieldTypeMapper mapper;
	@Override
	public boolean save(CrmFieldType bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CrmFieldType bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CrmFieldType findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult deleteByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
