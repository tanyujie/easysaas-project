package org.easymis.easysaas.crm.service;

import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.dto.Role;

import com.github.pagehelper.Page;

/**
 * <p>
 * 服务类
 * </p>
 */
public interface RoleService {
	Role findById(String roleId);
	List getPage(Page page, Role bean);
	List<Role> list(List<String> roleIdList);
	List<Role> getList(Role role);

	List<Role> list();

	List<Role> findByRoleIds(List<String> roleIds);

	List<Role> findByRoleNames(List<String> roleNames);

	Role findByRoleSn(String roleSn);
	RestResult save(Role bean);
	RestResult update(Role bean);
	void delete(String roleId);

}
