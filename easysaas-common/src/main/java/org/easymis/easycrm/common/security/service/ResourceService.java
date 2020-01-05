package org.easymis.easycrm.common.security.service;

import org.easymis.easycrm.common.security.userdetail.Resource;

public interface ResourceService {
	Resource  getOne(String requestURI);
	Resource findByEndPoint(String endPoint);
}
