package org.easymis.easysaas.crm.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmFieldSort;

public interface CrmFieldSortMapper {
	@Select("select * from crm_field_sort")
	public List<CrmFieldSort> getList(HashMap<String, Object> params);

	@Insert("insert into crm_field_sort(id,org_id,label,field_name,name,type,sort,staff_id,is_hide,field_id)values(#{id},#{orgId},#{label},#{fieldName},#{name},#{type},#{sort},#{staffId},#{isHide},#{fieldId})")
	public void save(CrmFieldSort bean);

	@Insert("insert into crm_field_sort(id,org_id,label,field_name,name,type,sort,staff_id,is_hide,field_id)values(#{id},#{orgId},#{label},#{fieldName},#{name},#{type},#{sort},#{staffId},#{isHide},#{fieldId})")
	public void saveBatch(List<CrmFieldSort> beans);

	@Update("UPDATE crm_field_sort SET id= #{id},org_id= #{orgId},label= #{label},field_name= #{fieldName},name= #{name},type= #{type},sort= #{sort},staff_id= #{staffId},is_hide= #{isHide},field_id= #{fieldId} WHERE id= #{id}")
	public void update(CrmFieldSort bean);

	@Delete(" DELETE FROM crm_field_sort WHERE id = #{id}")
	public void delete(String id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_field_sort t WHERE t.id = #{id}")
	public CrmFieldSort findById(String id);

	@Select(" SELECT t.* FROM crm_field_sort t ")
	public List<CrmFieldSort> findByIds(List<String> list);
	
	@Select("select count(*) from crm_field_sort where org_id =#{orgId} and staff_id =#{staffId} and label =#{label}")
	public Integer getCount(@Param("orgId")String orgId,@Param("staffId")String staffId,@Param("label")String label);
}