package org.easymis.easycrm.core.service.impl;

import org.easymis.easycrm.core.entitys.mybatis.dto.Company;
import org.easymis.easycrm.core.entitys.mybatis.mapper.CompanyMapper;
import org.easymis.easycrm.core.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyMapper mapper;
	@Override
	public Company getById(String companyId) {
		// TODO Auto-generated method stub
		return mapper.findById(companyId);
	}

}
