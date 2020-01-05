package org.easymis.easycrm.common.service;

import org.easymis.easycrm.common.entitys.mybatis.dto.CompanyCategoryCode;

public interface CompanyCategoryCodeService {
	CompanyCategoryCode findByCategoryCode(String categoryCode);
}
