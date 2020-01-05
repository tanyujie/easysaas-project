package org.easymis.easysaas.core.security.service.impl;

import java.util.List;

import org.easymis.easysaas.core.entitys.mybatis.mapper.RoleMapper;
import org.easymis.easysaas.core.security.service.RoleService;
import org.easymis.easysaas.core.security.userdetail.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleMapper mapper;
	@Override
	public List<Role> list(List<String> roleIdList) {
		// TODO Auto-generated method stub
		return mapper.findByRoleIds(roleIdList);
	}

	@Override
	public List<Role> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findByRoleIds(List<String> roleIds) {
		// TODO Auto-generated method stub
		return mapper.findByRoleIds(roleIds);
	}

	@Override
	public List<Role> findByRoleNames(List<String> roleNames) {
		// TODO Auto-generated method stub
		return mapper.findByRoleNames(roleNames);
	}

}
