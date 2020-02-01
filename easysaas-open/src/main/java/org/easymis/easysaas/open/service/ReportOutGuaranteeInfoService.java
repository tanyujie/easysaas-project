package org.easymis.easysaas.open.service;

import java.util.List;

import org.easymis.easysaas.open.entitys.mybatis.dto.ReportOutGuaranteeInfo;

/**
 * 
　 * <p>Title: 对外提供保证担保信息 服务类</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
public interface ReportOutGuaranteeInfoService extends IService<ReportOutGuaranteeInfo> {
    List<ReportOutGuaranteeInfo> listByAnnualreportId(List<String> annualReportIds);
}
