package org.easymis.easycrm.operation.service;

import org.easymis.easycrm.operation.entitys.mybatis.dto.CompanyCategoryCode;

public interface CompanyCategoryCodeService {
	CompanyCategoryCode findByCategoryCode(String categoryCode);
}
