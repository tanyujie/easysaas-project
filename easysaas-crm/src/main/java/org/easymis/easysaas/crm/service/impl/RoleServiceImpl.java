package org.easymis.easysaas.crm.service.impl;

import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.config.datasource.DataSourceType;
import org.easymis.easysaas.crm.config.datasource.EasymisDataSource;
import org.easymis.easysaas.crm.entitys.dto.Role;
import org.easymis.easysaas.crm.mapper.RoleMapper;
import org.easymis.easysaas.crm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

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

	@Override
	public Role findById(String roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPage(Page page, Role bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getList(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult save(Role bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult update(Role bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String roleId) {
		// TODO Auto-generated method stub
		
	}

}
