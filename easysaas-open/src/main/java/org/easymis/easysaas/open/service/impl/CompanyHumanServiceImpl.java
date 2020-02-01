package org.easymis.easysaas.open.service.impl;

import java.util.List;

import org.easymis.easysaas.open.config.datasource.DataSourceType;
import org.easymis.easysaas.open.config.datasource.EasymisDataSource;
import org.easymis.easysaas.open.entitys.mybatis.dto.Human;
import org.easymis.easysaas.open.entitys.mybatis.mapper.CompanyHumanMapper;
import org.easymis.easysaas.open.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CompanyHumanServiceImpl implements HumanService {
	@Autowired
	CompanyHumanMapper mapper;

	@EasymisDataSource(DataSourceType.Slave)
	public List findByHumanInvestorIds(List humaninvestorIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountByCompanyId(Object companyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@EasymisDataSource(DataSourceType.Slave)
	public Human getById(String staffId) {
		// TODO Auto-generated method stub
		return mapper.getById(staffId);
	}

	@EasymisDataSource(DataSourceType.Slave)
	public List<Human> list(List<String> humaninvestorIds) {
		// TODO Auto-generated method stub
		return mapper.list(humaninvestorIds);
	}


}
