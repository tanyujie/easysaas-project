package org.easymis.easysaas.core.security.service.impl;

import org.easymis.easysaas.core.entitys.mybatis.mapper.ResourceMapper;
import org.easymis.easysaas.core.security.service.ResourceService;
import org.easymis.easysaas.core.security.userdetail.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	ResourceMapper mapper;
	@Override
	public Resource getOne(String requestURI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource findByEndPoint(String endPoint) {
		// TODO Auto-generated method stub
		return mapper.findByEndPoint(endPoint);
	}

}
