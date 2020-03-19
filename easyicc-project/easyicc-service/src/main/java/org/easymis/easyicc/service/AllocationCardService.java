package org.easymis.easyicc.service;

import java.util.List;
import java.util.Map;

import org.easymis.easyicc.domain.vo.StaffSalesVo;

public interface AllocationCardService{
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
	/**
	 * 手工分配名片
	 * @param companyId
	 * @param cardId
	 * @param userId
	 * @param operatorId
	 */
	public boolean userAllocationCard(String companyId, String cardId, String userId, String operatorId);
	public boolean allocation(String cardId);
	
	public void clearCache(String companyId,String userId);
	/**
	 * 清除轮循算法缓存
	 * @param companyId
	 * @param userId
	 */
	public void clearAlternateCache(String companyId,String userId);
}
