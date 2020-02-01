package org.easymis.easysaas.open.service;

import java.util.List;

import org.easymis.easysaas.open.entitys.mybatis.dto.CompanyLicenseInfoCreditchina;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * 
　 * <p>Title: 行政许可 服务类</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
public interface CompanyLicenseInfoCreditchinaService extends IService<CompanyLicenseInfoCreditchina> {
    Integer getCountByCompanyName(String name);
    List<CompanyLicenseInfoCreditchina> findListByCompanyName(String companyName);
	PageInfo getPage( Page page,String companyName);
}
