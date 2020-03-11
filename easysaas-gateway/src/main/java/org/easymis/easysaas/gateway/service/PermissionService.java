package org.easymis.easysaas.gateway.service;

import java.util.List;

import org.easymis.easysaas.gateway.entitys.mybatis.dto.Permission;

public interface PermissionService {
	Permission getOne(String requestURI);

	Permission findByEndPoint(String endPoint);

	List<Permission> findByMemberId(String memberNo);
}
