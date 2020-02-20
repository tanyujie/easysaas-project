package org.easymis.easysaas.crm.service.impl;

import java.util.List;

import org.easymis.easysaas.crm.config.datasource.DataSourceType;
import org.easymis.easysaas.crm.config.datasource.EasymisDataSource;
import org.easymis.easysaas.crm.entitys.mybatis.dto.RoleResource;
import org.easymis.easysaas.crm.entitys.mybatis.mapper.RolePermissionMapper;
import org.easymis.easysaas.crm.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
	@Autowired
	RolePermissionMapper mapper;
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
