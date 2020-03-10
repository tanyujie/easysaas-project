package org.easymis.easysaas.crm.service;

import java.util.List;

import org.easymis.easysaas.crm.entitys.dto.Permission;

public interface PermissionService {
	Permission getOne(String requestURI);

	Permission findByEndPoint(String endPoint);

	List<Permission> findByMemberId(String memberNo);
}
