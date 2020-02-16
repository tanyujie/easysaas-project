package org.easymis.easysaas.portal.service;

import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyChangeInfo;

import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 公司变更信息 服务类
 * </p>
 */
public interface CompanyChangeInfoService extends IService<CompanyChangeInfo> {
	PageInfo findByPage(String companyId,Integer pageNum, Integer pageSize);
}
