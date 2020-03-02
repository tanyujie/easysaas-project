package org.easymis.easysaas.crm.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmRival;

public interface CrmRivalMapper {
	@Select("select * from crm_rival")
	public List<CrmRival> getList(HashMap<String, Object> params);

	@Insert("insert into crm_rival(rival_id,creator_id,create_time,org_id,rival_name,owner_id,scale_id,scale_name,contact_address,contact_telephone,competition_id,competition_name,goodness,strategy,weakness,website,update_time,update_id,delete_status,delete_id,delete_time,depict)values(#{rivalId},#{creatorId},#{createTime},#{orgId},#{rivalName},#{ownerId},#{scaleId},#{scaleName},#{contactAddress},#{contactTelephone},#{competitionId},#{competitionName},#{goodness},#{strategy},#{weakness},#{website},#{updateTime},#{updateId},#{deleteStatus},#{deleteId},#{deleteTime},#{depict})")
	public void save(CrmRival bean);

	@Insert("insert into crm_rival(rival_id,creator_id,create_time,org_id,rival_name,owner_id,scale_id,scale_name,contact_address,contact_telephone,competition_id,competition_name,goodness,strategy,weakness,website,update_time,update_id,delete_status,delete_id,delete_time,depict)values(#{rivalId},#{creatorId},#{createTime},#{orgId},#{rivalName},#{ownerId},#{scaleId},#{scaleName},#{contactAddress},#{contactTelephone},#{competitionId},#{competitionName},#{goodness},#{strategy},#{weakness},#{website},#{updateTime},#{updateId},#{deleteStatus},#{deleteId},#{deleteTime},#{depict})")
	public void saveBatch(List<CrmRival> beans);

	@Update("UPDATE crm_rival SET rival_id= #{rivalId},creator_id= #{creatorId},create_time= #{createTime},org_id= #{orgId},rival_name= #{rivalName},owner_id= #{ownerId},scale_id= #{scaleId},scale_name= #{scaleName},contact_address= #{contactAddress},contact_telephone= #{contactTelephone},competition_id= #{competitionId},competition_name= #{competitionName},goodness= #{goodness},strategy= #{strategy},weakness= #{weakness},website= #{website},update_time= #{updateTime},update_id= #{updateId},delete_status= #{deleteStatus},delete_id= #{deleteId},delete_time= #{deleteTime},depict= #{depict} WHERE rival_id= #{rivalId}")
	public void update(CrmRival bean);

	@Delete(" DELETE FROM crm_rival WHERE rival_id = #{rivalId}")
	public void delete(String rival_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_rival t WHERE t.rival_id = #{rivalId}")

	public CrmRival findById(String rival_id);

	@Select(" SELECT t.* FROM crm_rival t }")
	public List<CrmRival> findByIds(List<String> list);
}