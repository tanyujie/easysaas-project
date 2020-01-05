package org.easymis.easysaas.core.service;

import org.easymis.easysaas.core.entitys.mybatis.dto.Company;

public interface CompanyService {
	public Company getById(String companyId);
}
