package org.easymis.easysaas.open.service.impl;

import java.util.List;

import org.easymis.easysaas.open.config.datasource.DataSourceType;
import org.easymis.easysaas.open.config.datasource.EasymisDataSource;
import org.easymis.easysaas.open.entitys.mybatis.dto.ReportShareholder;
import org.easymis.easysaas.open.entitys.mybatis.mapper.ReportShareholderMapper;
import org.easymis.easysaas.open.service.ReportShareholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReportShareholderServiceImpl implements ReportShareholderService {
	@Autowired
	ReportShareholderMapper mapper;
	@Override
	public int getCountByCompanyId(Object companyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@EasymisDataSource(DataSourceType.Slave)
	public List<ReportShareholder> listByAnnualReportId(List<String> annualReportIds) {
		// TODO Auto-generated method stub
		return mapper.findByAnnualreportIds(annualReportIds);
	}

}
