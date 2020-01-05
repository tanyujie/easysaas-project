package org.easymis.easycrm.common.service;

import org.easymis.easycrm.common.entitys.mybatis.dto.Company;

public interface CompanyService {
	public Company getById(String companyId);
}
