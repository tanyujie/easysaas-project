package org.easymis.easysaas.open.service;


import java.util.List;

import org.easymis.easysaas.open.entitys.mybatis.dto.ReportWebinfo;

/**
 * 
　 * <p>Title: 网站或网店信息 服务类</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
public interface ReportWebinfoService extends IService<ReportWebinfo> {
    List<ReportWebinfo> listByAnnualreportId(List<String> annualReportIds);
}
