package org.easymis.easysaas.gateway.service;

import org.easymis.easysaas.gateway.entitys.mybatis.dto.Resource;

public interface ResourceService {
	Resource  getOne(String requestURI);
	Resource findByEndPoint(String endPoint);
}
