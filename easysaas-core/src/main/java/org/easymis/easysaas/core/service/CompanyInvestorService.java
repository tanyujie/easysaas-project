package org.easymis.easycrm.core.service;

import java.util.List;

import org.easymis.easycrm.core.entitys.mybatis.vo.CompanyInvestorVo;

public interface CompanyInvestorService {
	List findByList(CompanyInvestorVo vo);
}
