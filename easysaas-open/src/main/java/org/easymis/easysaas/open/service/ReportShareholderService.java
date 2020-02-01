package org.easymis.easysaas.open.service;

import java.util.List;

import org.easymis.easysaas.open.entitys.mybatis.dto.ReportShareholder;

/**
 * 
　 * <p>Title:  股东及出资信息 服务类</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
public interface ReportShareholderService extends IService<ReportShareholder> {
	 List<ReportShareholder> listByAnnualReportId(List<String> annualReportIds);
}
