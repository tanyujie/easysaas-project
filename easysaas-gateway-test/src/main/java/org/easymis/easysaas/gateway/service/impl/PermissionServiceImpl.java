package org.easymis.easysaas.gateway.service.impl;

import java.util.List;

import org.easymis.easysaas.gateway.config.datasource.DataSourceType;
import org.easymis.easysaas.gateway.config.datasource.EasymisDataSource;
import org.easymis.easysaas.gateway.entitys.mybatis.dto.Permission;
import org.easymis.easysaas.gateway.entitys.mybatis.mapper.PermissionMapper;
import org.easymis.easysaas.gateway.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	PermissionMapper mapper;
	@EasymisDataSource(DataSourceType.Master)
	public Permission getOne(String requestURI) {
		// TODO Auto-generated method stub
		return null;
	}

	@EasymisDataSource(DataSourceType.Master)
	public Permission findByEndPoint(String endPoint) {
		// TODO Auto-generated method stub
		return mapper.findByEndPoint(endPoint);
	}

	@Override
	public List<Permission> findByMemberId(String memberNo) {
		// TODO Auto-generated method stub
		return mapper.findByMemberId(memberNo);
	}

}
