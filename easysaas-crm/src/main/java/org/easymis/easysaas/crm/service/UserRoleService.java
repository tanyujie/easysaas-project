package org.easymis.easysaas.crm.service;

import java.util.List;

import org.easymis.easysaas.crm.entitys.dto.UserRole;

public interface UserRoleService {

	String roleUser = "ROLE_USER"; // 默认的用户权限

	String guest = "ROLE_ANONYMOUS";

	List<UserRole> findByMemberId(String userNo);

}
