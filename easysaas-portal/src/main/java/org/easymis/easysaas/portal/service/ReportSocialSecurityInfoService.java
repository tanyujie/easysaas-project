package org.easymis.easysaas.portal.service;


import java.util.List;

import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportSocialSecurityInfo;

/**
 * 
　 * <p>Title: ReportSocialSecurityInfoService</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
public interface ReportSocialSecurityInfoService extends IService<ReportSocialSecurityInfo> {
    List<ReportSocialSecurityInfo> listByAnnaulreportId(List<String> annualReportIds);
}
