package org.easymis.easysaas.portal.service;

import java.util.List;

import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyStaff;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;


/**
 * 
　 * <p>Title: CompanyStaffService</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月29日
 */
public interface CompanyStaffService extends IService<CompanyStaff> {
    List<CompanyStaff> findByCompanyId(String companyId);
    List<CompanyStaff> findList(String companyId,List<String> humaninvestorIds);
	PageInfo getPage( Page page,String companyId);
}
