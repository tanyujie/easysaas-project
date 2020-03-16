package org.easymis.easysaas.imserver.service.impl;

import java.util.List;

import org.easymis.easysaas.imserver.entitys.mybatis.mapper.BackTypeMapper;
import org.easymis.easysaas.imserver.service.BackTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BackTypeServiceImpl implements BackTypeService {
	@Autowired
	private BackTypeMapper mapper;
	@Override
	public List findByOrgId(String orgId) {
		// TODO Auto-generated method stub
		return mapper.findByOrgId(orgId);
	}

}
