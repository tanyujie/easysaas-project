package org.easymis.easysaas.crm.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.dto.CrmCustomerFocus;

public interface CrmCustomerFocusMapper {
	@Select("select * from crm_customer_focus")
	public List<CrmCustomerFocus> getList(HashMap<String, Object> params);

	@Insert("insert into crm_customer_focus(create_time,customer_id,depict,focus_id,org_id,staff_id)values(#{createTime},#{customerId},#{depict},#{focusId},#{orgId},#{staffId})")
	public void save(CrmCustomerFocus bean);

	@Insert("insert into crm_customer_focus(create_time,customer_id,depict,focus_id,org_id,staff_id)values(#{createTime},#{customerId},#{depict},#{focusId},#{orgId},#{staffId})")
	public void saveBatch(List<CrmCustomerFocus> beans);

	@Update("UPDATE crm_customer_focus SET create_time= #{createTime},customer_id= #{customerId},depict= #{depict},focus_id= #{focusId},org_id= #{orgId},staff_id= #{staffId} WHERE focus_id= #{focusId}")
	public void update(CrmCustomerFocus bean);

	@Delete(" DELETE FROM crm_customer_focus WHERE focus_id = #{focusId}")
	public void delete(String focus_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_customer_focus t WHERE t.focus_id = #{focusId}")
	public CrmCustomerFocus findById(String focus_id);

	@Select(" SELECT t.* FROM crm_customer_focus t }")
	public List<CrmCustomerFocus> findByIds(List<String> list);
}