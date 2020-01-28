package org.easymis.easysaas.portal.service;

import java.util.List;

import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportChangeRecord;



/**
 * <p>
 * 年报变更记录 服务类
 * </p>
 *
 * @author zh
 * @since 2019-07-11
 */
public interface ReportChangeRecordService extends IService<ReportChangeRecord> {
	List<ReportChangeRecord> listByAnnualreportId(List<Long> annualReportIds);
}
