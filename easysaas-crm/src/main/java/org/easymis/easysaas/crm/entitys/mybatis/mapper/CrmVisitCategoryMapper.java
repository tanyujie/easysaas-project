package org.easymis.easysaas.crm.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmVisitCategory;

public interface CrmVisitCategoryMapper {
	@Select("select * from crm_visit_category")

	public List<CrmVisitCategory> getList(HashMap<String, Object> params);

	@Insert("insert into crm_visit_category(category_id,depict,org_id,priority,status,subject_name)values(#{categoryId},#{depict},#{orgId},#{priority},#{status},#{subjectName})")
	public void save(CrmVisitCategory bean);

	@Insert("insert into crm_visit_category(category_id,depict,org_id,priority,status,subject_name)values(#{categoryId},#{depict},#{orgId},#{priority},#{status},#{subjectName})")
	public void saveBatch(List<CrmVisitCategory> beans);

	@Update("UPDATE crm_visit_category SET category_id= #{categoryId},depict= #{depict},org_id= #{orgId},priority= #{priority},status= #{status},subject_name= #{subjectName} WHERE category_id= #{categoryId}")
	public void update(CrmVisitCategory bean);

	@Delete(" DELETE FROM crm_visit_category WHERE category_id = #{categoryId}")
	public void delete(String category_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_visit_category t WHERE t.category_id = #{categoryId}")

	public CrmVisitCategory findById(String category_id);

	@Select(" SELECT t.* FROM crm_visit_category t }")
	public List<CrmVisitCategory> findByIds(List<String> list);
}