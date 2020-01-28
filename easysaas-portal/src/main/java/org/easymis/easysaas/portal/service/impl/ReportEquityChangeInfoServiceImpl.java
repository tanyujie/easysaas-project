package org.easymis.easysaas.portal.service.impl;

import java.util.List;

import org.easymis.easysaas.portal.config.datasource.DataSourceType;
import org.easymis.easysaas.portal.config.datasource.EasymisDataSource;
import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportEquityChangeInfo;
import org.easymis.easysaas.portal.entitys.mybatis.mapper.ReportEquityChangeInfoMapper;
import org.easymis.easysaas.portal.service.ReportEquityChangeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReportEquityChangeInfoServiceImpl implements ReportEquityChangeInfoService {
	@Autowired
	ReportEquityChangeInfoMapper mapper;
	@Override
	public int getCountByCompanyId(Object companyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@EasymisDataSource(DataSourceType.Slave)
	public List<ReportEquityChangeInfo> listByAnnualreportId(List<String> annualReportIds) {
		// TODO Auto-generated method stub
		return mapper.findByAnnualreportIds(annualReportIds);
	}

}
