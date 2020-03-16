package org.easymis.easysaas.imserver.service.impl;

import java.util.List;

import org.easymis.easysaas.imserver.entitys.mybatis.mapper.SchoolMapper;
import org.easymis.easysaas.imserver.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolMapper mapper;
	@Override
	public List findList(String orgId) {
		// TODO Auto-generated method stub
		return mapper.findByOrgId(orgId);
	}

}
