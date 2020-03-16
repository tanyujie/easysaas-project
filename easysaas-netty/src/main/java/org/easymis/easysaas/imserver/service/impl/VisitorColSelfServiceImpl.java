package org.easymis.easysaas.imserver.service.impl;

import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.VisitorColSelf;
import org.easymis.easysaas.imserver.entitys.mybatis.mapper.VisitorColSelfMapper;
import org.easymis.easysaas.imserver.service.VisitorColSelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
@Service
public class VisitorColSelfServiceImpl implements VisitorColSelfService {
	@Autowired
	private VisitorColSelfMapper mapper;
	@Override
	public boolean save(VisitorColSelf bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(VisitorColSelf bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VisitorColSelf findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByOrgId(String orgId) {
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
