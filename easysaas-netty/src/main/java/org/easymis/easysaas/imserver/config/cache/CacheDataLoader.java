package org.easymis.easysaas.imserver.config.cache;

import java.util.List;

import org.easymis.easysaas.imserver.config.cache.entity.SchedulingTime;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.CardRule;
import org.easymis.easysaas.imserver.entitys.vo.StaffInfoVo;

public interface CacheDataLoader {

	
	/**
	 * 获取分配规则
	 * @param companyId
	 * @return
	 */
	public CardRule getCardRule(String companyId);
	
	/**
	 * 获取销售人员
	 * @param companyId
	 * @param time
	 * @return
	 */
	public List<StaffInfoVo> getSaleUser(int companyId, String time, Boolean b);
	
	/**
	 * 获取排班信息
	 * @param companyId
	 * @param time
	 * @return
	 */
	public List<SchedulingTime> getSchedulingTimes(int companyId, String time);
	
	/**
	 * 获取已分配的名片
	 * @param companyId
	 * @param time
	 * @return
	 */
	//public List<Card> getAllocationedCards(int companyId, String time);
	
	
}
