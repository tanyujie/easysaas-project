package org.easymis.easysaas.open.service.impl;

import java.util.List;

import org.easymis.easysaas.open.config.datasource.DataSourceType;
import org.easymis.easysaas.open.config.datasource.EasymisDataSource;
import org.easymis.easysaas.open.entitys.mybatis.dto.CopyrightWorks;
import org.easymis.easysaas.open.entitys.mybatis.mapper.CopyrightWorksMapper;
import org.easymis.easysaas.open.service.CopyrightWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class CopyrightWorksServiceImpl implements CopyrightWorksService {
	@Autowired
	CopyrightWorksMapper mapper;
	
	@EasymisDataSource(DataSourceType.Slave)
	public PageInfo findByPage(String companyId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<CopyrightWorks> list = mapper.findByCompanyId(companyId);
		PageInfo<CopyrightWorks> page = new PageInfo<CopyrightWorks>(list);
		return page;
	}

}
