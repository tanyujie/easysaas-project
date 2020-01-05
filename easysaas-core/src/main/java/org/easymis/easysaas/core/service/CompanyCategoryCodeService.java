package org.easymis.easycrm.core.service;

import org.easymis.easycrm.core.entitys.mybatis.dto.CompanyCategoryCode;

public interface CompanyCategoryCodeService {
	CompanyCategoryCode findByCategoryCode(String categoryCode);
}
