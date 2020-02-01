package org.easymis.easysaas.open.service;

import java.util.List;

import org.easymis.easysaas.open.entitys.mybatis.dto.ReportEquityChangeInfo;

/**
 * 
　 * <p>Title: 股东股权变更信息 服务类</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
public interface ReportEquityChangeInfoService extends IService<ReportEquityChangeInfo> {
    List<ReportEquityChangeInfo> listByAnnualreportId(List<String> annualReportIds);
}
