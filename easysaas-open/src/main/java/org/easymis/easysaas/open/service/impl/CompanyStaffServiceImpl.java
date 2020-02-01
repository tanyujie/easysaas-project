package org.easymis.easysaas.open.service.impl;

import java.util.HashMap;
import java.util.List;

import org.easymis.easysaas.open.config.datasource.DataSourceType;
import org.easymis.easysaas.open.config.datasource.EasymisDataSource;
import org.easymis.easysaas.open.entitys.mybatis.dto.CompanyStaff;
import org.easymis.easysaas.open.entitys.mybatis.mapper.CompanyStaffMapper;
import org.easymis.easysaas.open.service.CompanyStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CompanyStaffServiceImpl implements CompanyStaffService {
	@Autowired
	CompanyStaffMapper mapper;

	@Override
	public int getCountByCompanyId(Object companyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@EasymisDataSource(DataSourceType.Slave)
	public List<CompanyStaff> findByCompanyId(String companyId) {
		// TODO Auto-generated method stub
		return mapper.findByCompanyId(companyId);
	}

	@Override
	@EasymisDataSource(DataSourceType.Slave)
	public List<CompanyStaff> findList(String companyId, List<String> humaninvestorIds) {
		HashMap map = new HashMap();
		map.put("companyId", companyId);
		map.put("ids", humaninvestorIds);
		return mapper.findList(companyId, humaninvestorIds);
	}

	@EasymisDataSource(DataSourceType.Slave)
	public PageInfo getPage(Page page, String companyId) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<CompanyStaff> list = mapper.findByCompanyId(companyId);
		PageInfo<CompanyStaff> pageInfo = new PageInfo<CompanyStaff>(list);
		return pageInfo;

	}
}
