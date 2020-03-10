package org.easymis.easysaas.crm.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.dto.CrmClueAllot;

public interface CrmClueAllotMapper {
	@Select("select * from crm_clue_allot")
	public List<CrmClueAllot> getList(HashMap<String, Object> params);

	@Insert("insert into crm_clue_allot(allot_id,allot_type,clue_id,create_id,create_time,delete_flag,hold_id,status,update_id,update_time)values(#{allotId},#{allotType},#{clueId},#{createId},#{createTime},#{deleteFlag},#{holdId},#{status},#{updateId},#{updateTime})")
	public void save(CrmClueAllot bean);

	@Insert("insert into crm_clue_allot(allot_id,allot_type,clue_id,create_id,create_time,delete_flag,hold_id,status,update_id,update_time)values(#{allotId},#{allotType},#{clueId},#{createId},#{createTime},#{deleteFlag},#{holdId},#{status},#{updateId},#{updateTime})")
	public void saveBatch(List<CrmClueAllot> beans);

	@Update("UPDATE crm_clue_allot SET allot_id= #{allotId},allot_type= #{allotType},clue_id= #{clueId},create_id= #{createId},create_time= #{createTime},delete_flag= #{deleteFlag},hold_id= #{holdId},status= #{status},update_id= #{updateId},update_time= #{updateTime} WHERE allot_id= #{allotId}")
	public void update(CrmClueAllot bean);

	@Delete(" DELETE FROM crm_clue_allot WHERE allot_id = #{allotId}")
	public void delete(String allot_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_clue_allot t WHERE t.allot_id = #{allotId}")
	public CrmClueAllot findById(String allot_id);

	@Select(" SELECT t.* FROM crm_clue_allot t }")
	public List<CrmClueAllot> findByIds(List<String> list);
}