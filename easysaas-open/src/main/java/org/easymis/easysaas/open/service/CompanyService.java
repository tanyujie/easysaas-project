package org.easymis.easysaas.open.service;

import java.util.List;

import org.easymis.easysaas.open.entitys.mybatis.dto.Company;

public interface CompanyService {

	/**
	 * @param id
	 */
	/**
	 * 
	 * <p>
	 * Title: getById
	 * </p>
	 * <p>
	 * Description: 获取某一个公司详细信息
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	public Company getById(String id);

	/**
	 * 获取全部
	 */
	public List<Company> getAll();
	List<Company> findByIds(List<String> companyIds);
	/**
	 * 
	 * <p>
	 * Title: search
	 * </p>
	 * <p>
	 * Description: 根据关键词搜索
	 * </p>
	 * @param content @return
	 */
	public List<Company> search(String content);

	/**
	 * 
	 * <p>
	 * Title: save
	 * </p>
	 * <p>
	 * Description: 单个插入
	 * </p>
	 * 
	 * @param bean
	 */
	public void insert(String id);
	public void insert();
	/**
	 * 
	 * <p>
	 * Title: save
	 * </p>
	 * <p>
	 * Description: 批量插入
	 * </p>
	 * 
	 * @param beans
	 */
	public void save(List<Company> beans);

	/**
	 * 
	 * <p>
	 * Title: deleteBatch
	 * </p>
	 * <p>
	 * Description:批量删除
	 * </p>
	 * 
	 * @param list
	 */
	public void deleteBatch(List<String> list);

	/**
	 * 
	 * <p>
	 * Title: delete
	 * </p>
	 * <p>
	 * Description: 根据id删除数据
	 * </p>
	 * 
	 * @param id
	 */
	public void delete(String id);

}
