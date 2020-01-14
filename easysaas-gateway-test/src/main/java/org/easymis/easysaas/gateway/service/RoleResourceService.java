package org.easymis.easysaas.gateway.service;

import java.util.List;

import org.easymis.easysaas.gateway.entitys.mybatis.dto.RoleResource;

/**
 * <p>
 * 服务类
 * </p>
 */
public interface RoleResourceService {
	List<RoleResource> list(String resourceId);
	List<RoleResource> findByResourceId(String resourceId);
}
