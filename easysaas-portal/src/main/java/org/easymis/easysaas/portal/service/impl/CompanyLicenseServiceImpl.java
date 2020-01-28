package org.easymis.easysaas.portal.service.impl;

import java.util.List;

import org.easymis.easysaas.portal.config.datasource.DataSourceType;
import org.easymis.easysaas.portal.config.datasource.EasymisDataSource;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyLicense;
import org.easymis.easysaas.portal.entitys.mybatis.mapper.CompanyLicenseMapper;
import org.easymis.easysaas.portal.service.CompanyLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CompanyLicenseServiceImpl implements CompanyLicenseService {
	@Autowired
	CompanyLicenseMapper mapper;
	@Override
	public int getCountByCompanyId(Object companyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@EasymisDataSource(DataSourceType.Slave)
	public List<CompanyLicense> findListByCompanyId(String companyId) {
		// TODO Auto-generated method stub
		return mapper.findByCompanyId(companyId);
	}
	@EasymisDataSource(DataSourceType.Slave)
	public PageInfo getPage(Page page, String companyId) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<CompanyLicense> list = mapper.findByCompanyId(companyId);
		PageInfo<CompanyLicense> pageInfo = new PageInfo<CompanyLicense>(list);
		return pageInfo;

	}
}
