package org.easymis.easysaas.core.service;

import java.util.List;

import org.easymis.easysaas.core.entitys.mybatis.vo.CompanyInvestorVo;

public interface CompanyInvestorService {
	List findByList(CompanyInvestorVo vo);
}
