package org.easymis.easysaas.imserver.config.cache;

import java.util.List;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.Card;
import org.easymis.easysaas.imserver.entitys.vo.StaffInfoVo;

public interface SubjectUserCache {
	
	public List<StaffInfoVo> getAllStaffInfoVos(String orgId);

	public List<StaffInfoVo> getUsersOfSubjectId(String orgId, String subjectID, String schoolId);

	public void allocationCard(StaffInfoVo user, Card card);
	
	public void backCard(String orgId, int cardId, String userId);
	
	public void finished(String orgId, int cardId, String userId, boolean isSaleCard);
	
	public void userAllocationCard(String orgId, Card card, String userId);
	
	public void remove(String orgId);
	
	public void init(String orgId, List<StaffInfoVo> users);

	public void expired(String orgId, int cardId, String userId);

	public StaffInfoVo getUser(String orgId, String userId);
	
}
