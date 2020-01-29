package org.easymis.easysaas.portal.service.impl;

import java.util.List;

import org.easymis.easysaas.portal.config.datasource.DataSourceType;
import org.easymis.easysaas.portal.config.datasource.EasymisDataSource;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyInvestor;
import org.easymis.easysaas.portal.entitys.mybatis.mapper.CompanyInvestorMapper;
import org.easymis.easysaas.portal.entitys.vo.CompanyInvestorVo;
import org.easymis.easysaas.portal.service.CompanyInvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CompanyInvestorServiceImpl implements CompanyInvestorService {
	@Autowired
	CompanyInvestorMapper mapper;
	@EasymisDataSource(DataSourceType.Slave)
	public int getCountByCompanyId(Object companyId) {
		// TODO Auto-generated method stub
		return 0;
	}
	@EasymisDataSource(DataSourceType.Slave)
	public List findByList(CompanyInvestorVo vo) {
		// TODO Auto-generated method stub
		return null;
	}
	@EasymisDataSource(DataSourceType.Slave)
	public List<CompanyInvestor> findListByCompanyId(String companyId) {
		// TODO Auto-generated method stub
		return mapper.findListByCompanyId(companyId);
	}
	@EasymisDataSource(DataSourceType.Slave)
	public PageInfo getPage(Page page, String companyId) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<CompanyInvestor> list = mapper.findListByCompanyId(companyId);
		PageInfo<CompanyInvestor> pageInfo = new PageInfo<CompanyInvestor>(list);
		return pageInfo;

	}

}
