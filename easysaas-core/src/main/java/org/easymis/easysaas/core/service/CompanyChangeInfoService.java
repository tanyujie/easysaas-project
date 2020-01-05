package org.easymis.easysaas.core.service;

import org.easymis.easysaas.core.entitys.mybatis.vo.CompanyChangeVo;

import com.github.pagehelper.Page;

public interface CompanyChangeInfoService {
	Page findByPage(CompanyChangeVo vo);
}
