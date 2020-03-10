package org.easymis.easysaas.crm.service.impl;

import java.util.List;

import org.easymis.easysaas.crm.config.datasource.DataSourceType;
import org.easymis.easysaas.crm.config.datasource.EasymisDataSource;
import org.easymis.easysaas.crm.entitys.dto.UserRole;
import org.easymis.easysaas.crm.mapper.UserRoleMapper;
import org.easymis.easysaas.crm.service.RoleService;
import org.easymis.easysaas.crm.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper mapper;
    
    @Autowired
    RoleService roleService;
	@EasymisDataSource(DataSourceType.Master)
	public List<UserRole> findByMemberId(String userNo) {
		// TODO Auto-generated method stub
		return mapper.findByMemberId(userNo);
	}

}
