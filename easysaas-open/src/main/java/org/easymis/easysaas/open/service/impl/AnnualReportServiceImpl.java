package org.easymis.easysaas.open.service.impl;

import java.util.List;

import org.easymis.easysaas.open.config.datasource.DataSourceType;
import org.easymis.easysaas.open.config.datasource.EasymisDataSource;
import org.easymis.easysaas.open.entitys.mybatis.dto.AnnualReport;
import org.easymis.easysaas.open.entitys.mybatis.mapper.AnnualReportMapper;
import org.easymis.easysaas.open.service.AnnualReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class AnnualReportServiceImpl implements AnnualReportService {
	@Autowired
	AnnualReportMapper mapper;
	@Override
	public int getCountByCompanyId(Object companyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@EasymisDataSource(DataSourceType.Slave)
	public PageInfo getPage(Page page, String companyId) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<AnnualReport> list = mapper.findByCompanyId(companyId);
		PageInfo<AnnualReport> pageInfo = new PageInfo<AnnualReport>(list);
		return pageInfo;

	}

}
