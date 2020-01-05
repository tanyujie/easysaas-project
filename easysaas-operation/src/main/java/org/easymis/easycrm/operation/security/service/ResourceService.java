package org.easymis.easycrm.operation.security.service;

import org.easymis.easycrm.operation.security.userdetail.Resource;

public interface ResourceService {
	Resource  getOne(String requestURI);
	Resource findByEndPoint(String endPoint);
}
