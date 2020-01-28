package org.easymis.easysaas.oa.service.impl;

import java.util.List;

import org.easymis.easysaas.oa.config.datasource.DataSourceType;
import org.easymis.easysaas.oa.config.datasource.EasymisDataSource;
import org.easymis.easysaas.oa.entitys.mybatis.dto.OaDiary;
import org.easymis.easysaas.oa.service.OaDiaryService;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
@Service
public class OaDiaryServiceImpl implements OaDiaryService {

	@EasymisDataSource(DataSourceType.Master)
	public List<OaDiary> getList(OaDiary bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@EasymisDataSource(DataSourceType.Master)
	public PageInfo findByPage(OaDiary bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@EasymisDataSource(DataSourceType.Master)
	public void save(OaDiary bean) {
		// TODO Auto-generated method stub
		
	}

	@EasymisDataSource(DataSourceType.Master)
	public void saveBatch(List<OaDiary> beans) {
		// TODO Auto-generated method stub
		
	}

	@EasymisDataSource(DataSourceType.Master)
	public void update(OaDiary bean) {
		// TODO Auto-generated method stub
		
	}

	@EasymisDataSource(DataSourceType.Master)
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@EasymisDataSource(DataSourceType.Master)
	public void removeBatch(List<String> list) {
		// TODO Auto-generated method stub
		
	}

	@EasymisDataSource(DataSourceType.Master)
	public void restoreBatch(List<String> list) {
		// TODO Auto-generated method stub
		
	}

	@EasymisDataSource(DataSourceType.Master)
	public void deleteBatch(List<String> list) {
		// TODO Auto-generated method stub
		
	}

	@EasymisDataSource(DataSourceType.Master)
	public OaDiary findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@EasymisDataSource(DataSourceType.Master)
	public Integer findCountByCompanyId(Long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@EasymisDataSource(DataSourceType.Master)
	public List<OaDiary> findByIds(List<String> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
