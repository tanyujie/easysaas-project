package org.easymis.easycrm.mobile.service;

import org.easymis.easycrm.mobile.entitys.mybatis.vo.CompanyChangeVo;

import com.github.pagehelper.Page;

public interface CompanyChangeInfoService {
	Page findByPage(CompanyChangeVo vo);
}
