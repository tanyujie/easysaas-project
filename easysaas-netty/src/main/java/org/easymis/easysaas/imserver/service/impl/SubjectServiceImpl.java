package org.easymis.easysaas.imserver.service.impl;

import java.util.List;

import org.easymis.easysaas.imserver.entitys.mybatis.mapper.SubjectMapper;
import org.easymis.easysaas.imserver.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectMapper mapper;
	@Override
	public List findList(String orgId) {
		// TODO Auto-generated method stub
		return mapper.findByOrgId(orgId);
	}

}
