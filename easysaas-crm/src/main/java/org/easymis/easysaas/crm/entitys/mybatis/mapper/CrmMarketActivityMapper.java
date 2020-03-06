package org.easymis.easysaas.crm.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmMarketActivity;

public interface CrmMarketActivityMapper {
	@Select("select * from crm_market_activity")

	public List<CrmMarketActivity> getList(HashMap<String, Object> params);

	@Insert("insert into crm_market_activity(activity_id,creator_id,org_id,activity_name,begin_date,end_sdate,category_id,address,expected_cost,actual_cost,actual_income,expected_income,marketing_plan,execution_description,summary,effect,description,participant_ids,owner_id,create_time,update_id,update_time,delete_id,delete_time,leads_id,business_id,product_id,customer_id,status)values(#{activityId},#{creatorId},#{orgId},#{activityName},#{beginDate},#{endSdate},#{categoryId},#{address},#{expectedCost},#{actualCost},#{actualIncome},#{expectedIncome},#{marketingPlan},#{executionDescription},#{summary},#{effect},#{description},#{participantIds},#{ownerId},#{createTime},#{updateId},#{updateTime},#{deleteId},#{deleteTime},#{leadsId},#{businessId},#{productId},#{customerId},#{status})")
	public void save(CrmMarketActivity bean);

	@Insert("insert into crm_market_activity(activity_id,creator_id,org_id,activity_name,begin_date,end_sdate,category_id,address,expected_cost,actual_cost,actual_income,expected_income,marketing_plan,execution_description,summary,effect,description,participant_ids,owner_id,create_time,update_id,update_time,delete_id,delete_time,leads_id,business_id,product_id,customer_id,status)values(#{activityId},#{creatorId},#{orgId},#{activityName},#{beginDate},#{endSdate},#{categoryId},#{address},#{expectedCost},#{actualCost},#{actualIncome},#{expectedIncome},#{marketingPlan},#{executionDescription},#{summary},#{effect},#{description},#{participantIds},#{ownerId},#{createTime},#{updateId},#{updateTime},#{deleteId},#{deleteTime},#{leadsId},#{businessId},#{productId},#{customerId},#{status})")
	public void saveBatch(List<CrmMarketActivity> beans);

	@Update("UPDATE crm_market_activity SET activity_id= #{activityId},creator_id= #{creatorId},org_id= #{orgId},activity_name= #{activityName},begin_date= #{beginDate},end_sdate= #{endSdate},category_id= #{categoryId},address= #{address},expected_cost= #{expectedCost},actual_cost= #{actualCost},actual_income= #{actualIncome},expected_income= #{expectedIncome},marketing_plan= #{marketingPlan},execution_description= #{executionDescription},summary= #{summary},effect= #{effect},description= #{description},participant_ids= #{participantIds},owner_id= #{ownerId},create_time= #{createTime},update_id= #{updateId},update_time= #{updateTime},delete_id= #{deleteId},delete_time= #{deleteTime},leads_id= #{leadsId},business_id= #{businessId},product_id= #{productId},customer_id= #{customerId},status= #{status} WHERE activity_id= #{activityId}")
	public void update(CrmMarketActivity bean);

	@Delete(" DELETE FROM crm_market_activity WHERE activity_id = #{activityId}")
	public void delete(String activity_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_market_activity t WHERE t.activity_id = #{activityId}")
	public CrmMarketActivity findById(String activity_id);

	@Select(" SELECT t.* FROM crm_market_activity t }")
	public List<CrmMarketActivity> findByIds(List<String> list);
}