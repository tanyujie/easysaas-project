package org.easymis.easysaas.member.service;

import java.util.List;

import org.easymis.easysaas.member.entitys.mybatis.dto.Role;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface RoleService {
	   List<Role> list(List<String> roleIdList );
	   List<Role> list();
	   List<Role> findByRoleIds(List<String> roleIds);
	   List<Role> findByRoleNames(List<String> roleNames);
	   Role findByRoleSn(String roleSn);

}
