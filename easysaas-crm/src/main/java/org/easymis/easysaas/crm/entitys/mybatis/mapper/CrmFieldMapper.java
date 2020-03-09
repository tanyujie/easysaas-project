package org.easymis.easysaas.crm.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmField;
import org.easymis.easysaas.crm.entitys.vo.ColumnHeadVo;
import org.easymis.easysaas.crm.entitys.vo.CrmFieldVo;

public interface CrmFieldMapper {

	@Select({"<script>",
        "SELECT * from crm_field",
        " <where> " +
        " <if test=\"orgId != null\">org_id=#{orgId}</if> " +
        " <if test=\"label != null\"> AND label=#{label}</if> " +
        " </where> " +
        "</script>"}) 
	public List<CrmField> getList(CrmField params);

	@Insert("insert into crm_field(field_id,org_id,table_code,field_code,field_name,name,field_tip,field_type,inner_default,state,create_user_id,create_time,update_user_id,update_time,remark,sorting,max_length,default_value,is_unique,is_null,operating)values(#{fieldId},#{orgId},#{tableCode},#{fieldCode},#{fieldName},#{name},#{fieldTip},#{fieldType},#{innerDefault},#{state},#{createUserId},#{createTime},#{updateUserId},#{updateTime},#{remark},#{sorting},#{maxLength},#{defaultValue},#{isUnique},#{isNull},#{operating})")
	public void save(CrmField bean);

	@Insert("insert into crm_field(field_id,org_id,table_code,field_code,field_name,name,field_tip,field_type,inner_default,state,create_user_id,create_time,update_user_id,update_time,remark,sorting,max_length,default_value,is_unique,is_null,operating)values(#{fieldId},#{orgId},#{tableCode},#{fieldCode},#{fieldName},#{name},#{fieldTip},#{fieldType},#{innerDefault},#{state},#{createUserId},#{createTime},#{updateUserId},#{updateTime},#{remark},#{sorting},#{maxLength},#{defaultValue},#{isUnique},#{isNull},#{operating})")
	public void saveBatch(List<CrmField> beans);

	@Update("UPDATE crm_field SET field_id= #{fieldId},org_id= #{orgId},table_code= #{tableCode},field_code= #{fieldCode},field_name= #{fieldName},name= #{name},field_tip= #{fieldTip},field_type= #{fieldType},inner_default= #{innerDefault},state= #{state},create_user_id= #{createUserId},create_time= #{createTime},update_user_id= #{updateUserId},update_time= #{updateTime},remark= #{remark},sorting= #{sorting},max_length= #{maxLength},default_value= #{defaultValue},is_unique= #{isUnique},is_null= #{isNull},operating= #{operating} WHERE field_id= #{fieldId}")
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
	
	@Select(" SELECT t.* FROM crm_field t where org_id=#{orgId}")
	public List<CrmField> findByOrgId(@Param("orgId")String orgId);
	
	@Select("select field_name,name,type,field_id from crm_field_sort where is_hide = 0 and org_id=#{orgId} and label = #{label} and staff_id = #{staffId} order by sort asc")
	public List<ColumnHeadVo> getColumnHead(@Param("orgId") String orgId,@Param("label") String label, @Param("staffId") String staffId);

	@Select("select field_id,field_name,name,field_type,options from crm_field "
			+ "where org_id=#{orgId} and inner_flag = 0 and label = #{label}")
	public List<CrmFieldVo> customerFieldList(@Param("orgId") String orgId, @Param("label") String label);
}