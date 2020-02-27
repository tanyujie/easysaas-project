package org.easymis.easysaas.crm.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmForm;

public interface CrmFormMapper {
	@Select("select * from crm_form")
	public List<CrmForm> getList(HashMap<String, Object> params);

	@Insert("insert into crm_form(form_id,form_name,form_type,create_user_id,create_time,update_user_id,update_time,org_id)values(#{formId},#{formName},#{formType},#{createUserId},#{createTime},#{updateUserId},#{updateTime},#{orgId})")
	public void save(CrmForm bean);

	@Insert("insert into crm_form(form_id,form_name,form_type,create_user_id,create_time,update_user_id,update_time,org_id)values(#{formId},#{formName},#{formType},#{createUserId},#{createTime},#{updateUserId},#{updateTime},#{orgId})")
	public void saveBatch(List<CrmForm> beans);

	@Update("UPDATE crm_form SET form_id= #{formId},form_name= #{formName},form_type= #{formType},create_user_id= #{createUserId},create_time= #{createTime},update_user_id= #{updateUserId},update_time= #{updateTime},org_id= #{orgId} WHERE form_id= #{formId}")
	public void update(CrmForm bean);

	@Delete(" DELETE FROM crm_form WHERE form_id = #{formId}")
	public void delete(String form_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	public CrmForm findById(String form_id);

	@Select(" SELECT t.* FROM crm_form t }")
	public List<CrmForm> findByIds(List<String> list);
}