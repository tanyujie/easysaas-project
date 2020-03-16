package org.easymis.easysaas.imserver.service.impl;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.School;
import org.easymis.easysaas.imserver.entitys.mybatis.mapper.SchoolMapper;
import org.easymis.easysaas.imserver.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolMapper mapper;
	@Override
	public School findByOrgId(String orgId) {
		// TODO Auto-generated method stub
		return mapper.findByOrgId(orgId);
	}
	@Override
	public boolean save(School bean) {
		return mapper.insertByBean(bean);	
	}
	@Override
	public boolean update(School bean) {
		return mapper.update(bean);
	}
	@Override
	public RestResult deleteByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public School findById(String id) {
		return mapper.findById(id);
	}
	@Override
	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
