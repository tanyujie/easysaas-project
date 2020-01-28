package org.easymis.easysaas.portal.service;

import java.util.List;

import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportChangeRecord;



/**
 * 
　 * <p>Title: 年报变更记录 服务类</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
public interface ReportChangeRecordService extends IService<ReportChangeRecord> {
	List<ReportChangeRecord> listByAnnualreportId(List<String> annualReportIds);
}
