package org.easymis.easysaas.crm.service.impl;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.SchoolArea;
import org.easymis.easysaas.crm.entitys.mybatis.mapper.SchoolAreaMapper;
import org.easymis.easysaas.crm.service.SchoolAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

@Service
public class SchoolAreaServiceImpl implements SchoolAreaService{
	@Autowired
	private SchoolAreaMapper mapper;
	@Override
	public boolean save(SchoolArea bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(SchoolArea bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SchoolArea findById(String id) {
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
