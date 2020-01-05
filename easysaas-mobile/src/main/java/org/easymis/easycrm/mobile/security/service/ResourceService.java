package org.easymis.easycrm.mobile.security.service;

import org.easymis.easycrm.mobile.security.userdetail.Resource;

public interface ResourceService {
	Resource  getOne(String requestURI);
	Resource findByEndPoint(String endPoint);
}
