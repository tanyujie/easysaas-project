package org.easymis.easysaas.imserver.service;

import java.util.List;
import java.util.Map;

import org.easymis.easysaas.imserver.config.cache.CacheDataLoader;
import org.easymis.easysaas.imserver.entitys.vo.StaffSalesVo;

public interface AllocationCardService extends CacheDataLoader{
	List<StaffSalesVo> getCanAllocationSaleUser(String companyId, String subjectId, String schoolId);
	public Map<String, String> getStatus(String companyId) throws  Exception;
	/**
	 * 更新名片校区
	 * @param cardId
	 * @param modifyIdentity
	 * @param subjectId
	 * @param schoolId
	 * @return
	 */
	public boolean updateCard(String cardId, String modifyIdentity, String subjectId, String schoolId);
	/**
	 * 设置无效
	 * @param companyId
	 * @param cardId
	 * @return
	 */
	public boolean setNotValidate(String companyId, String cardId);
}
