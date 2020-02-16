package org.easymis.easysaas.portal.service;

import java.util.List;

import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyInvestor;
import org.easymis.easysaas.portal.entitys.vo.CompanyInverstVo;
import org.easymis.easysaas.portal.entitys.vo.CompanyInvestorVo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * 
　 * <p>Title: CompanyInvestorService</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月29日
 */
public interface CompanyInvestorService extends IService<CompanyInvestor> {
	List findByList(CompanyInvestorVo vo);
    List<CompanyInvestor> findByCompanyId(String companyId);
    //获取对外投资列表
    PageInfo getInverstList(String companyId,Page page);
	PageInfo getPage( Page page,String companyId);
}
