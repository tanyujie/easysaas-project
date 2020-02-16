package org.easymis.easysaas.portal.service.impl;

import java.util.List;

import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyChangeInfo;
import org.easymis.easysaas.portal.entitys.mybatis.mapper.CompanyChangeInfoMapper;
import org.easymis.easysaas.portal.service.CompanyChangeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CompanyChangeInfoServiceImpl implements CompanyChangeInfoService {
	@Autowired
	CompanyChangeInfoMapper mapper;
	@Override
	public int getCountByCompanyId(Object companyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo findByPage(String companyId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<CompanyChangeInfo> list = mapper.findByCompanyId(companyId);
		PageInfo<CompanyChangeInfo> page = new PageInfo<CompanyChangeInfo>(list);
		return page;

	}

}
