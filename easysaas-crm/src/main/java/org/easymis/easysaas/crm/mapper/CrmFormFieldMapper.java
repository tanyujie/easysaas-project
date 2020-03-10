package org.easymis.easysaas.crm.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.dto.CrmFormField;

public interface CrmFormFieldMapper {
	@Select("select * from crm_form_field")
	public List<CrmFormField> getList(HashMap<String, Object> params);

	@Insert("insert into crm_form_field(form_field_id,table_code,field_id,form_id,group_id,required,sort,org_id)values(#{formFieldId},#{tableCode},#{fieldId},#{formId},#{groupId},#{required},#{sort},#{orgId})")
	public void save(CrmFormField bean);

	@Insert("insert into crm_form_field(form_field_id,table_code,field_id,form_id,group_id,required,sort,org_id)values(#{formFieldId},#{tableCode},#{fieldId},#{formId},#{groupId},#{required},#{sort},#{orgId})")
	public void saveBatch(List<CrmFormField> beans);

	@Update("UPDATE crm_form_field SET form_field_id= #{formFieldId},table_code= #{tableCode},field_id= #{fieldId},form_id= #{formId},group_id= #{groupId},required= #{required},sort= #{sort},org_id= #{orgId} WHERE form_field_id= #{formFieldId}")
	public void update(CrmFormField bean);

	@Delete(" DELETE FROM crm_form_field WHERE form_field_id = #{formFieldId}")
	public void delete(String form_field_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_form_field t WHERE t.form_field_id = #{formFieldId}")
	public CrmFormField findById(String form_field_id);

	@Select(" SELECT t.* FROM crm_form_field t }")
	public List<CrmFormField> findByIds(List<String> list);
}