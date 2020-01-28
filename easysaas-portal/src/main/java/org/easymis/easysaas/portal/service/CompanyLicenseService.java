package org.easymis.easysaas.portal.service;

import java.util.List;

import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyLicense;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * 
　 * <p>Title: 行政许可 服务类</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
public interface CompanyLicenseService extends IService<CompanyLicense> {
    List<CompanyLicense> findListByCompanyId(String companyId);
	PageInfo getPage( Page page,String companyId);
}
