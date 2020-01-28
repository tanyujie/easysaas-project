package org.easymis.easysaas.portal.service.impl;

import java.util.List;

import org.easymis.easysaas.portal.config.datasource.DataSourceType;
import org.easymis.easysaas.portal.config.datasource.EasymisDataSource;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyLicenseInfoCreditchina;
import org.easymis.easysaas.portal.entitys.mybatis.mapper.CompanyLicenseInfoCreditchinaMapper;
import org.easymis.easysaas.portal.service.CompanyLicenseInfoCreditchinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CompanyLicenseInfoCreditchinaServiceImpl implements CompanyLicenseInfoCreditchinaService {
	
	
	@Autowired
	CompanyLicenseInfoCreditchinaMapper mapper;
	
	@EasymisDataSource(DataSourceType.Slave)
	public int getCountByCompanyId(Object companyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@EasymisDataSource(DataSourceType.Slave)
	public Integer getCountByCompanyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@EasymisDataSource(DataSourceType.Slave)
	public List<CompanyLicenseInfoCreditchina> findListByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		return mapper.findListByCompanyName(companyName);
	}

	@EasymisDataSource(DataSourceType.Slave)
	public PageInfo getPage(Page page, String companyName) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<CompanyLicenseInfoCreditchina> list = mapper.findListByCompanyName(companyName);
		PageInfo<CompanyLicenseInfoCreditchina> pageInfo = new PageInfo<CompanyLicenseInfoCreditchina>(list);
		return pageInfo;
	}

}
