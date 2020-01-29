package org.easymis.easysaas.portal.service.impl;

import java.util.List;

import org.easymis.easysaas.portal.config.datasource.DataSourceType;
import org.easymis.easysaas.portal.config.datasource.EasymisDataSource;
import org.easymis.easysaas.portal.entitys.mybatis.dto.SoftwareCopyright;
import org.easymis.easysaas.portal.entitys.mybatis.mapper.SoftwareCopyrightMapper;
import org.easymis.easysaas.portal.service.SoftwareCopyrightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class SoftwareCopyrightServiceImpl implements SoftwareCopyrightService {
	@Autowired
	SoftwareCopyrightMapper mapper;
	
	@EasymisDataSource(DataSourceType.Slave)
	public PageInfo findByPage(String companyId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SoftwareCopyright> list = mapper.findByCompanyId(companyId);
		PageInfo<SoftwareCopyright> page = new PageInfo<SoftwareCopyright>(list);
		return page;
	}

}
