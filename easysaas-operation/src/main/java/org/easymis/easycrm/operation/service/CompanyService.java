package org.easymis.easycrm.operation.service;

import org.easymis.easycrm.operation.entitys.mybatis.dto.Company;

public interface CompanyService {
	public Company getById(String companyId);
}
