package org.easymis.easycrm.operation.service;

import java.util.List;

import org.easymis.easycrm.operation.entitys.mybatis.vo.CompanyInvestorVo;

public interface CompanyInvestorService {
	List findByList(CompanyInvestorVo vo);
}
