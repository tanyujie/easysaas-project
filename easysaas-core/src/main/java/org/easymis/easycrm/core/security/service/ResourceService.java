package org.easymis.easycrm.core.security.service;

import org.easymis.easycrm.core.security.userdetail.Resource;

public interface ResourceService {
	Resource  getOne(String requestURI);
	Resource findByEndPoint(String endPoint);
}
