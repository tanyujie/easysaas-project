package org.easymis.easyicc.service.impl;

import java.util.List;

import org.easymis.easyicc.common.result.RestResult;
import org.easymis.easyicc.domain.entity.Subject;
import org.easymis.easyicc.mybatis.mapper.SubjectMapper;
import org.easymis.easyicc.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectMapper mapper;
	@Override
	public List findByOrgId(String orgId) {
		// TODO Auto-generated method stub
		return mapper.findByOrgId(orgId);
	}
	@Override
	public boolean save(Subject bean) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(Subject bean) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Subject findById(String id) {
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
