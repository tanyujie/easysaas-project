package org.easymis.easysaas.portal.service.impl;

import org.easymis.easysaas.portal.config.datasource.DataSourceType;
import org.easymis.easysaas.portal.config.datasource.EasymisDataSource;
import org.easymis.easysaas.portal.entitys.mybatis.dto.IdentityCardAddress;
import org.easymis.easysaas.portal.entitys.mybatis.mapper.IdentityCardAddressMapper;
import org.easymis.easysaas.portal.service.IdentityCardAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class IdentityCardAddressServiceImpl implements IdentityCardAddressService {
	@Autowired
	IdentityCardAddressMapper mapper;
	@EasymisDataSource(DataSourceType.Slave)
	public IdentityCardAddress findProvince(String base) {
		// TODO Auto-generated method stub
		return mapper.findProvince(base);
	}

}
