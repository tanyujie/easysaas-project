package org.easymis.easysaas.member.security.service.impl;

import java.util.List;

import org.easymis.easysaas.member.config.datasource.DataSourceType;
import org.easymis.easysaas.member.config.datasource.EasymisDataSource;
import org.easymis.easysaas.member.security.service.RoleService;
import org.easymis.easysaas.member.security.userdetail.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharepanzer.companydata.core.web.mapper.RoleMapper;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleMapper mapper;
	@EasymisDataSource(DataSourceType.Master)
	public List<Role> list(List<String> roleIdList) {
		// TODO Auto-generated method stub
		return mapper.findByRoleIds(roleIdList);
	}

	@EasymisDataSource(DataSourceType.Master)
	public List<Role> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@EasymisDataSource(DataSourceType.Master)
	public List<Role> findByRoleIds(List<String> roleIds) {
		// TODO Auto-generated method stub
		return mapper.findByRoleIds(roleIds);
	}

	@EasymisDataSource(DataSourceType.Master)
	public List<Role> findByRoleNames(List<String> roleNames) {
		// TODO Auto-generated method stub
		return mapper.findByRoleNames(roleNames);
	}

	@EasymisDataSource(DataSourceType.Master)
	public Role findByRoleSn(String roleSn) {
		// TODO Auto-generated method stub
		return null;
	}

}
