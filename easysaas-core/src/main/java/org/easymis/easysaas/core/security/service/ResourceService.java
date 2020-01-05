package org.easymis.easysaas.core.security.service;

import org.easymis.easysaas.core.security.userdetail.Resource;

public interface ResourceService {
	Resource  getOne(String requestURI);
	Resource findByEndPoint(String endPoint);
}
