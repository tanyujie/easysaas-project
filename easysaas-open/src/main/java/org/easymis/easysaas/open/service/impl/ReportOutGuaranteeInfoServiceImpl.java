package org.easymis.easysaas.open.service.impl;

import java.util.List;

import org.easymis.easysaas.open.config.datasource.DataSourceType;
import org.easymis.easysaas.open.config.datasource.EasymisDataSource;
import org.easymis.easysaas.open.entitys.mybatis.dto.ReportOutGuaranteeInfo;
import org.easymis.easysaas.open.entitys.mybatis.mapper.ReportOutGuaranteeInfoMapper;
import org.easymis.easysaas.open.service.ReportOutGuaranteeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReportOutGuaranteeInfoServiceImpl implements ReportOutGuaranteeInfoService {
	@Autowired
	ReportOutGuaranteeInfoMapper mapper;
	@Override
	public int getCountByCompanyId(Object companyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@EasymisDataSource(DataSourceType.Slave)
	public List<ReportOutGuaranteeInfo> listByAnnualreportId(List<String> annualReportIds) {
		// TODO Auto-generated method stub
		return mapper.findByAnnualreportIds(annualReportIds);
	}

}
