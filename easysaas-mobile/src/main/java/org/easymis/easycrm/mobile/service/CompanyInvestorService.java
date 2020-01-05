package org.easymis.easycrm.mobile.service;

import java.util.List;

import org.easymis.easycrm.mobile.entitys.mybatis.vo.CompanyInvestorVo;

public interface CompanyInvestorService {
	List findByList(CompanyInvestorVo vo);
}
