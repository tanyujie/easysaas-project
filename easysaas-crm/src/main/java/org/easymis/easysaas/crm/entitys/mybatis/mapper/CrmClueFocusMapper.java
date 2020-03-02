package org.easymis.easysaas.crm.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmClueFocus;

public interface CrmClueFocusMapper {
	@Select("select * from crm_clue_focus")
	public List<CrmClueFocus> getList(HashMap<String, Object> params);

	@Insert("insert into crm_clue_focus(clue_id,create_time,depict,focus_id,org_id,staff_id)values(#{clueId},#{createTime},#{depict},#{focusId},#{orgId},#{staffId})")
	public void save(CrmClueFocus bean);

	@Insert("insert into crm_clue_focus(clue_id,create_time,depict,focus_id,org_id,staff_id)values(#{clueId},#{createTime},#{depict},#{focusId},#{orgId},#{staffId})")
	public void saveBatch(List<CrmClueFocus> beans);

	@Update("UPDATE crm_clue_focus SET clue_id= #{clueId},create_time= #{createTime},depict= #{depict},focus_id= #{focusId},org_id= #{orgId},staff_id= #{staffId} WHERE focus_id= #{focusId}")
	public void update(CrmClueFocus bean);

	@Delete(" DELETE FROM crm_clue_focus WHERE focus_id = #{focusId}")
	public void delete(String focus_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_clue_focus t WHERE t.focus_id = #{focusId}")
	public CrmClueFocus findById(String focus_id);

	@Select(" SELECT t.* FROM crm_clue_focus t }")
	public List<CrmClueFocus> findByIds(List<String> list);
}