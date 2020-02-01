package org.easymis.easysaas.open.service.impl;

import java.util.List;

import org.easymis.easysaas.open.config.datasource.DataSourceType;
import org.easymis.easysaas.open.config.datasource.EasymisDataSource;
import org.easymis.easysaas.open.entitys.mybatis.dto.ReportChangeRecord;
import org.easymis.easysaas.open.entitys.mybatis.mapper.ReportChangeRecordMapper;
import org.easymis.easysaas.open.service.ReportChangeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReportChangeRecordServiceImpl implements ReportChangeRecordService {
	@Autowired
	ReportChangeRecordMapper mapper;
	@Override
	public int getCountByCompanyId(Object companyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@EasymisDataSource(DataSourceType.Slave)
	public List<ReportChangeRecord> listByAnnualreportId(List<String> annualReportIds) {
		// TODO Auto-generated method stub
		return mapper.findByAnnualreportIds(annualReportIds);
	}

}
