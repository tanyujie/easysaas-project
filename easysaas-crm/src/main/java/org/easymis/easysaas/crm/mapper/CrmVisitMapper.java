package org.easymis.easysaas.crm.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.dto.CrmVisit;

public interface CrmVisitMapper {
	@Select("select * from crm_visit")
	public List<CrmVisit> getList(HashMap<String, Object> params);

	@Insert("insert into crm_visit(visit_id,creator_id,create_time,org_id,customer_id,category_id,content,visit_date,finish_time,owner_id,assistant_id,comment_content,comment_id,comment_date,update_id,update_time,delete_id,delete_time,leads_id,business_id,product_id,status)values(#{visitId},#{creatorId},#{createTime},#{orgId},#{customerId},#{categoryId},#{content},#{visitDate},#{finishTime},#{ownerId},#{assistantId},#{commentContent},#{commentId},#{commentDate},#{updateId},#{updateTime},#{deleteId},#{deleteTime},#{leadsId},#{businessId},#{productId},#{status})")
	public void save(CrmVisit bean);

	@Insert("insert into crm_visit(visit_id,creator_id,create_time,org_id,customer_id,category_id,content,visit_date,finish_time,owner_id,assistant_id,comment_content,comment_id,comment_date,update_id,update_time,delete_id,delete_time,leads_id,business_id,product_id,status)values(#{visitId},#{creatorId},#{createTime},#{orgId},#{customerId},#{categoryId},#{content},#{visitDate},#{finishTime},#{ownerId},#{assistantId},#{commentContent},#{commentId},#{commentDate},#{updateId},#{updateTime},#{deleteId},#{deleteTime},#{leadsId},#{businessId},#{productId},#{status})")
	public void saveBatch(List<CrmVisit> beans);

	@Update("UPDATE crm_visit SET visit_id= #{visitId},creator_id= #{creatorId},create_time= #{createTime},org_id= #{orgId},customer_id= #{customerId},category_id= #{categoryId},content= #{content},visit_date= #{visitDate},finish_time= #{finishTime},owner_id= #{ownerId},assistant_id= #{assistantId},comment_content= #{commentContent},comment_id= #{commentId},comment_date= #{commentDate},update_id= #{updateId},update_time= #{updateTime},delete_id= #{deleteId},delete_time= #{deleteTime},leads_id= #{leadsId},business_id= #{businessId},product_id= #{productId},status= #{status} WHERE visit_id= #{visitId}")
	public void update(CrmVisit bean);

	@Delete(" DELETE FROM crm_visit WHERE visit_id = #{visitId}")
	public void delete(String visit_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_visit t WHERE t.visit_id = #{visitId}")
	public CrmVisit findById(String visit_id);

	@Select(" SELECT t.* FROM crm_visit t }")
	public List<CrmVisit> findByIds(List<String> list);
}