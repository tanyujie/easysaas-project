package org.easymis.easysaas.crm.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmPromotionChannel;

public interface CrmPromotionChannelMapper {
	@Select("select * from crm_promotion_channel")
	public List<CrmPromotionChannel> getList(
			HashMap<String, Object> params);

	@Insert("insert into crm_promotion_channel(channel_id,channel_name,api_config)values(#{channelId},#{channelName},#{apiConfig})")
	public void save(CrmPromotionChannel bean);

	@Insert("insert into crm_promotion_channel(channel_id,channel_name,api_config)values(#{channelId},#{channelName},#{apiConfig})")
	public void saveBatch(List<CrmPromotionChannel> beans);

	@Update("UPDATE crm_promotion_channel SET channel_id= #{channelId},channel_name= #{channelName},api_config= #{apiConfig} WHERE channel_id= #{channelId}")
	public void update(CrmPromotionChannel bean);

	@Delete(" DELETE FROM crm_promotion_channel WHERE channel_id = #{channelId}")
	public void delete(String channel_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_promotion_channel t WHERE t.channel_id = #{channelId}")
	@Results(value = { @Result(property = "channelId", column = "channel_id"),
			@Result(property = "channelName", column = "channel_name"),
			@Result(property = "apiConfig", column = "api_config") })
	public CrmPromotionChannel findById(String channel_id);

	@Select(" SELECT t.* FROM crm_promotion_channel t }")
	public List<CrmPromotionChannel> findByIds(List<String> list);
}