package org.easymis.easysaas.open.service.impl;

import org.easymis.easysaas.open.config.datasource.DataSourceType;
import org.easymis.easysaas.open.config.datasource.EasymisDataSource;
import org.easymis.easysaas.open.service.CompanyLicenseEntpubService;
import org.springframework.stereotype.Service;
@Service
public class CompanyLicenseEntpubServiceImpl implements CompanyLicenseEntpubService {

	@EasymisDataSource(DataSourceType.Slave)
	public int getCountByCompanyId(Object companyId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
