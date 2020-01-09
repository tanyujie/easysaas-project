package org.easymis.easysaas.gateway.security.service.impl;

import java.util.List;

import org.easymis.easysaas.gateway.config.datasource.DataSourceType;
import org.easymis.easysaas.gateway.config.datasource.EasymisDataSource;
import org.easymis.easysaas.gateway.security.service.RoleResourceService;
import org.easymis.easysaas.gateway.security.userdetail.RoleResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharepanzer.companydata.core.web.mapper.RoleResourceMapper;
@Service
public class RoleResourceServiceImpl implements RoleResourceService {
	@Autowired
	RoleResourceMapper mapper;
	@EasymisDataSource(DataSourceType.Master)
	public List<RoleResource> list(String resourceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@EasymisDataSource(DataSourceType.Master)
	public List<RoleResource> findByResourceId(String resourceId) {
		// TODO Auto-generated method stub
		return mapper.findByResourceId(resourceId);
	}

}
