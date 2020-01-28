package org.easymis.easysaas.portal.service;

import org.easymis.easysaas.portal.entitys.mybatis.dto.AnnualReport;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;


/**
 * 
　 * <p>Title: 企业年报 服务类</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
public interface AnnualReportService extends IService<AnnualReport> {
	PageInfo getPage( Page page,String companyId);
}
