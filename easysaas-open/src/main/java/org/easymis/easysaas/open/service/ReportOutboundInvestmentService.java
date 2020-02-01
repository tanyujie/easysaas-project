package org.easymis.easysaas.open.service;

import java.util.List;

import org.easymis.easysaas.open.entitys.mybatis.dto.ReportOutboundInvestment;

/**
 * 
　 * <p>Title: 对外投资 服务类</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
public interface ReportOutboundInvestmentService extends IService<ReportOutboundInvestment> {
	  List<ReportOutboundInvestment> listByAnnualReportId(List<String> annualReportIds);
}
