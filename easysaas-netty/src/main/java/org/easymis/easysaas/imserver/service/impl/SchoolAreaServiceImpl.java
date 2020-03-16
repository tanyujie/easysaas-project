package org.easymis.easysaas.imserver.service.impl;

import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.SchoolArea;
import org.easymis.easysaas.imserver.entitys.mybatis.mapper.SchoolAreaMapper;
import org.easymis.easysaas.imserver.service.SchoolAreaService;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;

public class SchoolAreaServiceImpl implements SchoolAreaService {
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

	@Override
	public List findByOrgId(String orgId) {
		// TODO Auto-generated method stub
		return null;
	}

}
