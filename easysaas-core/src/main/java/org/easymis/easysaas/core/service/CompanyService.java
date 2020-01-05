package org.easymis.easycrm.core.service;

import org.easymis.easycrm.core.entitys.mybatis.dto.Company;

public interface CompanyService {
	public Company getById(String companyId);
}
