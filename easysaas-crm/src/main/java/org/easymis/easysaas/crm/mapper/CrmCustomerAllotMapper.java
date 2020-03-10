package org.easymis.easysaas.crm.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.dto.CrmCustomerAllot;

public interface CrmCustomerAllotMapper {
	@Select("select * from crm_customer_allot")
	public List<CrmCustomerAllot> getList(HashMap<String, Object> params);

	@Insert("insert into crm_customer_allot(allot_id,allot_type,create_id,create_time,customer_id,delete_flag,hold_id,status,update_id,update_time)values(#{allotId},#{allotType},#{createId},#{createTime},#{customerId},#{deleteFlag},#{holdId},#{status},#{updateId},#{updateTime})")
	public void save(CrmCustomerAllot bean);

	@Insert("insert into crm_customer_allot(allot_id,allot_type,create_id,create_time,customer_id,delete_flag,hold_id,status,update_id,update_time)values(#{allotId},#{allotType},#{createId},#{createTime},#{customerId},#{deleteFlag},#{holdId},#{status},#{updateId},#{updateTime})")
	public void saveBatch(List<CrmCustomerAllot> beans);

	@Update("UPDATE crm_customer_allot SET allot_id= #{allotId},allot_type= #{allotType},create_id= #{createId},create_time= #{createTime},customer_id= #{customerId},delete_flag= #{deleteFlag},hold_id= #{holdId},status= #{status},update_id= #{updateId},update_time= #{updateTime} WHERE allot_id= #{allotId}")
	public void update(CrmCustomerAllot bean);

	@Delete(" DELETE FROM crm_customer_allot WHERE allot_id = #{allotId}")
	public void delete(String allot_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_customer_allot t WHERE t.allot_id = #{allotId}")
	public CrmCustomerAllot findById(String allot_id);

	@Select(" SELECT t.* FROM crm_customer_allot t }")
	public List<CrmCustomerAllot> findByIds(List<String> list);
}