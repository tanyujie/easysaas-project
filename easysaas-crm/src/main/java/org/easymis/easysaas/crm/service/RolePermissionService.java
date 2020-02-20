package org.easymis.easysaas.crm.service;

import java.util.List;

import org.easymis.easysaas.crm.entitys.mybatis.dto.RoleResource;

/**
 * <p>
 * 服务类
 * </p>
 */
public interface RolePermissionService {
	List<RoleResource> list(String resourceId);

	List<RoleResource> findByResourceId(String resourceId);
}
