package org.easymis.easysaas.gateway.service;

import java.util.List;

import org.easymis.easysaas.gateway.entitys.mybatis.dto.Role;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zh
 * @since 2019-09-03
 */
public interface RoleService {
	   List<Role> list(List<String> roleIdList );
	   List<Role> list();
	   List<Role> findByRoleIds(List<String> roleIds);
	   List<Role> findByRoleNames(List<String> roleNames);
	   Role findByRoleSn(String roleSn);

}
