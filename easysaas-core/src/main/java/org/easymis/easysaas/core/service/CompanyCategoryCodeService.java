package org.easymis.easysaas.core.service;

import org.easymis.easysaas.core.entitys.mybatis.dto.CompanyCategoryCode;

public interface CompanyCategoryCodeService {
	CompanyCategoryCode findByCategoryCode(String categoryCode);
}
