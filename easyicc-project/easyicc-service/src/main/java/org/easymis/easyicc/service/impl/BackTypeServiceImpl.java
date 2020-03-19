package org.easymis.easyicc.service.impl;

import java.util.List;

import org.easymis.easyicc.common.result.RestResult;
import org.easymis.easyicc.domain.entity.BackType;
import org.easymis.easyicc.mybatis.mapper.BackTypeMapper;
import org.easymis.easyicc.service.BackTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
@Service
public class BackTypeServiceImpl implements BackTypeService {
	@Autowired
	private BackTypeMapper mapper;
	@Override
	public List findByOrgId(String orgId) {
		// TODO Auto-generated method stub
		return mapper.findByOrgId(orgId);
	}
	@Override
	public boolean save(BackType bean) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(BackType bean) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public BackType findById(String id) {
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
