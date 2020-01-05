package org.easymis.easycrm.web.security.service;

import org.easymis.easycrm.web.security.userdetail.Resource;

public interface ResourceService {
	Resource  getOne(String requestURI);
	Resource findByEndPoint(String endPoint);
}
