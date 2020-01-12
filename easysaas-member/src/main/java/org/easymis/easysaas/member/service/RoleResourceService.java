package org.easymis.easysaas.member.service;

import java.util.List;

import org.easymis.easysaas.member.entitys.mybatis.dto.RoleResource;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @@author zh
 * @since 2019-09-05
 */
public interface RoleResourceService {
	List<RoleResource> list(String resourceId);
	List<RoleResource> findByResourceId(String resourceId);
}
