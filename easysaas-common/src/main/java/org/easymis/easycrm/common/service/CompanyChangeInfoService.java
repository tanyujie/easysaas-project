package org.easymis.easycrm.common.service;

import org.easymis.easycrm.common.entitys.mybatis.vo.CompanyChangeVo;

import com.github.pagehelper.Page;

public interface CompanyChangeInfoService {
	Page findByPage(CompanyChangeVo vo);
}
