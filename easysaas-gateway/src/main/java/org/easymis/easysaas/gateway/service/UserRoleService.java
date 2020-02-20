package org.easymis.easysaas.gateway.service;

import java.util.List;

import org.easymis.easysaas.gateway.security.userdetail.ExpireDateGrantedAuthority;
import org.easymis.easysaas.gateway.security.userdetail.UserRole;

public interface UserRoleService {

	String roleUser = "ROLE_USER"; // 默认的用户权限

	String guest = "ROLE_ANONYMOUS";

	List<ExpireDateGrantedAuthority> getGrantedAuthorityByMemberId(String memberId);

	List<UserRole> findByMemberId(String userNo);

}
