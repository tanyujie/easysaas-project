package org.easymis.easysaas.crm.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmField;

public interface CrmFieldMapper {
	@Select("select * from crm_field")
	public List<CrmField> getList(HashMap<String, Object> params);

	@Insert("insert into crm_field(field_id,table_code,field_code,field_name,field_tip,field_type,inner_default,state,create_user_id,create_time,update_user_id,update_time,org_id)values(#{fieldId},#{tableCode},#{fieldCode},#{fieldName},#{fieldTip},#{fieldType},#{innerDefault},#{state},#{createUserId},#{createTime},#{updateUserId},#{updateTime},#{orgId})")
	public void save(CrmField bean);

	@Insert("insert into crm_field(field_id,table_code,field_code,field_name,field_tip,field_type,inner_default,state,create_user_id,create_time,update_user_id,update_time,org_id)values(#{fieldId},#{tableCode},#{fieldCode},#{fieldName},#{fieldTip},#{fieldType},#{innerDefault},#{state},#{createUserId},#{createTime},#{updateUserId},#{updateTime},#{orgId})")
	public void saveBatch(List<CrmField> beans);

	@Update("UPDATE crm_field SET field_id= #{fieldId},table_code= #{tableCode},field_code= #{fieldCode},field_name= #{fieldName},field_tip= #{fieldTip},field_type= #{fieldType},inner_default= #{innerDefault},state= #{state},create_user_id= #{createUserId},create_time= #{createTime},update_user_id= #{updateUserId},update_time= #{updateTime},org_id= #{orgId} WHERE field_id= #{fieldId}")
	public void update(CrmField bean);

	@Delete(" DELETE FROM crm_field WHERE field_id = #{fieldId}")
	public void delete(String field_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_field t WHERE t.field_id = #{fieldId}")
	public CrmField findById(String field_id);

	@Select(" SELECT t.* FROM crm_field t")
	public List<CrmField> findByIds(List<String> list);
}
