package org.easymis.easysaas.member.service;

import org.easymis.easysaas.member.entitys.mybatis.dto.Resource;

public interface ResourceService {
	Resource  getOne(String requestURI);
	Resource findByEndPoint(String endPoint);
}
