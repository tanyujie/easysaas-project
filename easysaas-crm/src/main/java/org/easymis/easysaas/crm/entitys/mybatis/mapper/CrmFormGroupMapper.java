package org.easymis.easysaas.crm.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmFormGroup;

public interface CrmFormGroupMapper {
	@Select("select * from crm_form_group")
	public List<CrmFormGroup> getList(HashMap<String, Object> params);

	@Insert("insert into crm_form_group(group_id,group_name,form_id,sort)values(#{groupId},#{groupName},#{formId},#{sort})")
	public void save(CrmFormGroup bean);

	@Insert("insert into crm_form_group(group_id,group_name,form_id,sort)values(#{groupId},#{groupName},#{formId},#{sort})")
	public void saveBatch(List<CrmFormGroup> beans);

	@Update("UPDATE crm_form_group SET group_id= #{groupId},group_name= #{groupName},form_id= #{formId},sort= #{sort} WHERE group_id= #{groupId}")
	public void update(CrmFormGroup bean);

	@Delete(" DELETE FROM crm_form_group WHERE group_id = #{groupId}")
	public void delete(String group_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_form_group t WHERE t.group_id = #{groupId}")
	public CrmFormGroup findById(String group_id);

	@Select(" SELECT t.* FROM crm_form_group t }")
	public List<CrmFormGroup> findByIds(List<String> list);
}