package org.easymis.easysaas.open.service.impl;

import java.util.List;

import org.easymis.easysaas.open.config.datasource.DataSourceType;
import org.easymis.easysaas.open.config.datasource.EasymisDataSource;
import org.easymis.easysaas.open.entitys.mybatis.dto.ReportOutboundInvestment;
import org.easymis.easysaas.open.entitys.mybatis.mapper.ReportOutboundInvestmentMapper;
import org.easymis.easysaas.open.service.ReportOutboundInvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReportOutboundInvestmentServiceImpl implements ReportOutboundInvestmentService {
	@Autowired
	ReportOutboundInvestmentMapper mapper;
	@Override
	public int getCountByCompanyId(Object companyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@EasymisDataSource(DataSourceType.Slave)
	public List<ReportOutboundInvestment> listByAnnualReportId(List<String> annualReportIds) {
		// TODO Auto-generated method stub
		return mapper.findByAnnualreportIds(annualReportIds);
	}

}
