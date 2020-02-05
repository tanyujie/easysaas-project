package org.easymis.easysaas.portal.service;

import org.easymis.easysaas.portal.entitys.mybatis.dto.IdentityCardAddress;

public interface IdentityCardAddressService {
	public IdentityCardAddress findProvince(String base);
}
