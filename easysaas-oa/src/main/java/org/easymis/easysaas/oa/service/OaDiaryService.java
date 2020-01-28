package org.easymis.easysaas.oa.service;

import java.util.List;

import org.easymis.easysaas.oa.entitys.mybatis.dto.OaDiary;

import com.github.pagehelper.PageInfo;

public interface OaDiaryService {

	public List<OaDiary> getList(OaDiary bean);

	public PageInfo findByPage(OaDiary bean);

	public void save(OaDiary bean);

	public void saveBatch(List<OaDiary> beans);

	public void update(OaDiary bean);

	public void delete(String id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	public OaDiary findById(String id);

	public Integer findCountByCompanyId(Long companyId);

	public List<OaDiary> findByIds(List<String> list);

}
