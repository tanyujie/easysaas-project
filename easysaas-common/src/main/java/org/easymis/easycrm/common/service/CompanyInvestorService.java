package org.easymis.easycrm.common.service;

import java.util.List;

import org.easymis.easycrm.common.entitys.mybatis.vo.CompanyInvestorVo;

public interface CompanyInvestorService {
	List findByList(CompanyInvestorVo vo);
}
