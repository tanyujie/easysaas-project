package org.easymis.easysaas.crm.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmMarketActivityCategory;

public interface CrmMarketActivityCategoryMapper {
	@Select("select * from crm_market_activity_category")
	public List<CrmMarketActivityCategory> getList(HashMap<String, Object> params);

	@Insert("insert into crm_market_activity_category(category_id,category_name,org_id,priority,level,parent_id,is_leaf,depict)values(#{categoryId},#{categoryName},#{orgId},#{priority},#{level},#{parentId},#{isLeaf},#{depict})")
	public void save(CrmMarketActivityCategory bean);

	@Insert("insert into crm_market_activity_category(category_id,category_name,org_id,priority,level,parent_id,is_leaf,depict)values(#{categoryId},#{categoryName},#{orgId},#{priority},#{level},#{parentId},#{isLeaf},#{depict})")
	public void saveBatch(List<CrmMarketActivityCategory> beans);

	@Update("UPDATE crm_market_activity_category SET category_id= #{categoryId},category_name= #{categoryName},org_id= #{orgId},priority= #{priority},level= #{level},parent_id= #{parentId},is_leaf= #{isLeaf},depict= #{depict} WHERE category_id= #{categoryId}")
	public void update(CrmMarketActivityCategory bean);

	@Delete(" DELETE FROM crm_market_activity_category WHERE category_id = #{categoryId}")
	public void delete(String category_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_market_activity_category t WHERE t.category_id = #{categoryId}")
	public CrmMarketActivityCategory findById(String category_id);

	@Select(" SELECT t.* FROM crm_market_activity_category t }")
	public List<CrmMarketActivityCategory> findByIds(List<String> list);
}