package org.easymis.easycrm.core.service;

import org.easymis.easycrm.core.entitys.mybatis.vo.CompanyChangeVo;

import com.github.pagehelper.Page;

public interface CompanyChangeInfoService {
	Page findByPage(CompanyChangeVo vo);
}
