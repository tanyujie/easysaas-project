package org.easymis.easysaas.crm.service.impl;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.dto.School;
import org.easymis.easysaas.crm.mapper.SchoolMapper;
import org.easymis.easysaas.crm.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

@Service
public class SchoolServiceImpl implements SchoolService{
	@Autowired
	private SchoolMapper mapper;
	@Override
	public boolean save(School bean) {
		return mapper.insertByBean(bean);		
	}
	@Override
	public boolean update(School bean) {
		// TODO Auto-generated method stub
		return mapper.update(bean);
	}
	@Override
	public School findById(String id) {
		// TODO Auto-generated method stub
		return mapper.findById(id);
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
