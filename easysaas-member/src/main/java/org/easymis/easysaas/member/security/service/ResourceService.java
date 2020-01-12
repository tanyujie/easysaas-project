package org.easymis.easysaas.member.security.service;

import org.easymis.easysaas.member.security.userdetail.Resource;

public interface ResourceService {
	Resource  getOne(String requestURI);
	Resource findByEndPoint(String endPoint);
}
