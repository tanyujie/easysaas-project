package org.easymis.easycrm.web.service;

import java.util.List;

import org.easymis.easycrm.web.entitys.mybatis.vo.CompanyInvestorVo;

public interface CompanyInvestorService {
	List findByList(CompanyInvestorVo vo);
}
