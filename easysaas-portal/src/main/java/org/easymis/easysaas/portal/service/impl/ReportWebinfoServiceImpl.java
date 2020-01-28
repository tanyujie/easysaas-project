package org.easymis.easysaas.portal.service.impl;

import java.util.List;

import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportWebinfo;
import org.easymis.easysaas.portal.entitys.mybatis.mapper.ReportWebinfoMapper;
import org.easymis.easysaas.portal.service.ReportWebinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReportWebinfoServiceImpl implements ReportWebinfoService {
	@Autowired
	ReportWebinfoMapper mapper;
	@Override
	public int getCountByCompanyId(Object companyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReportWebinfo> listByAnnualreportId(List<String> annualReportIds) {
		// TODO Auto-generated method stub
		return mapper.findByAnnualreportIds(annualReportIds);
	}

}
