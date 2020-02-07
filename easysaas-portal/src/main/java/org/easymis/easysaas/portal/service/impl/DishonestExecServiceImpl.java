package org.easymis.easysaas.portal.service.impl;

import java.util.List;

import org.easymis.easysaas.portal.config.datasource.DataSourceType;
import org.easymis.easysaas.portal.config.datasource.EasymisDataSource;
import org.easymis.easysaas.portal.entitys.mybatis.dto.DishonestExec;
import org.easymis.easysaas.portal.entitys.mybatis.mapper.DishonestExecMapper;
import org.easymis.easysaas.portal.service.DishonestExecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class DishonestExecServiceImpl implements DishonestExecService {
	@Autowired
	DishonestExecMapper mapper;
	@EasymisDataSource(DataSourceType.Slave)
	public PageInfo findByPageOnDishonestId(String dishonestId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<DishonestExec> list = mapper.findByDishonestId(dishonestId);
		PageInfo<DishonestExec> page = new PageInfo<DishonestExec>(list);
		return page;

	}

}
