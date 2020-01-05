package org.easymis.easysaas.gateway.security.service;

import org.easymis.easysaas.gateway.security.userdetail.Resource;

public interface ResourceService {
	Resource  getOne(String requestURI);
	Resource findByEndPoint(String endPoint);
}
