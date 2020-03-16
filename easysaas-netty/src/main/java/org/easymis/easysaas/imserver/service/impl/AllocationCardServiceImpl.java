package org.easymis.easysaas.imserver.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.easymis.easysaas.imserver.config.cache.CacheFactory;
import org.easymis.easysaas.imserver.config.cache.entity.SchedulingTime;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.Card;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.CardLog;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.CardRule;
import org.easymis.easysaas.imserver.entitys.mybatis.mapper.CardMapper;
import org.easymis.easysaas.imserver.entitys.mybatis.mapper.VisitorInfoMapper;
import org.easymis.easysaas.imserver.entitys.vo.StaffInfoVo;
import org.easymis.easysaas.imserver.entitys.vo.StaffSalesVo;
import org.easymis.easysaas.imserver.service.AllocationCardService;
import org.easymis.easysaas.imserver.service.CardLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AllocationCardServiceImpl implements AllocationCardService {
	private final static SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
	private final static Log _logger = LogFactory.getLog(AllocationCardService.class);
	@Autowired
	private CacheFactory cacheFactory;
	@Autowired
	private CardMapper cardMapper;
	@Autowired
	private VisitorInfoMapper visitorInfoMapper;
	@Autowired
	private CardLogService cardLogService;
	@Override
	public List<StaffSalesVo> getCanAllocationSaleUser(String companyId, String subjectId, String schoolId) {
		String time = formatter2.format(new Date());
		cacheFactory.checkInit(companyId, this, time);
		List<StaffInfoVo> users = this.cacheFactory.getSubjectUserCache().getUsersOfSubjectId(companyId, subjectId, schoolId);
		_logger.info(String.format("公司[%s]-手动分配可用客服:初始分配客服[%s]", companyId, logUser(users)));
		return this.filterOnLineSaleUsers(companyId, users);
	}
	public List<StaffSalesVo> filterOnLineSaleUsers(String companyId, List<StaffInfoVo> users){
		List<StaffInfoVo> list = new ArrayList<StaffInfoVo>();
		try {
			List<UserSession> sessions = CoreClient.getUserMgr(companyId).getCustomers(companyId);
			Set<String> onlineIds = new HashSet<String>();
			CardRule cardRule = this.cacheFactory.getCardRuleCache().getCardRule(companyId);

			for(UserSession s : sessions){
				
				// needOnLine必须在线才能分配 1开启 0未开启
				if (cardRule.getNeedOnLine() == 1) {
					
					// isOnlineAllocation在线分配模式 0 在线分配(只有在线的状态可以进行名片的分配) 1在线分配(在线.忙碌.离开的状态可以进行名片的分配)
					if (cardRule.getIsOnlineAllocation() == 0) {
						if (s.getStatus() == UserSession.STATUS_ONLINE && (s.getRunningStatus() == 1 || s.getRunningStatus() == 0)) {
							onlineIds.add(s.getStaffId());
						}
					} else {
						if (s.getStatus() == UserSession.STATUS_ONLINE) {
							onlineIds.add(s.getStaffId());
						}
					}
				} else {
					onlineIds.add(s.getStaffId());
				}
			}
			
			for(StaffInfoVo user : users){
				if(onlineIds.contains(user.getStaffId())){
					_logger.info(String.format("[%s][%s]可以被分配, 当前分配情况：权重[%s], 分配量[%s], 退回量[%s], 有效量[%s]", user.getOrgId(),
							user.getStaffId(),user.getAllocationWeight(), user.getAllocationCount(), user.getBackCount(), user.getValidCount()));
					list.add(user);
				}
			}
			_logger.info(String.format("公司[%s]-手动分配可用客服:最终可分配客服[%s]", companyId, logUser(list)));
		} catch (Exception e) {
			_logger.error(e.getMessage(), e);
		}
		return list;
	}
	public Map<String, String> getStatus(String companyId) throws  Exception{
		Map<String, String> map = new HashMap<String, String>();
		List<UserSession> sessions = CoreClient.getUserMgr(companyId).getCustomers(companyId);
		for(UserSession s : sessions){
			String status = "offline";
			if(s.getStatus() != UserSession.STATUS_OFFLINE){
				if(s.getRunningStatus() == 1 || (s.getRunningStatus() == 2 && s.isAutoBussy())){
					status = "online";
				}else if(s.getRunningStatus() == 2){
					status = "buzy";
				}else if(s.getRunningStatus() == 3){
					status = "leave";
				}
			}
			map.put(s.getUserId(), status);
		}
		return map;
	}
	@Override
	public boolean updateCard(String cardId, String modifyIdentity, String subjectId, String schoolId) {
		//extColumn8项目 extColumn9校区
		String sql = "update js_visitor_info set ext_column8 = ?, ext_column9 = ?, modify_identity = ? where id = ? and modify_identity= ? ";
		int len = 0;//this.jdbcTemplate.update(sql, subjectId, schoolId, UUID.randomUUID().toString(), cardId, modifyIdentity);
		return len > 0 ?  true : false;
	}
	
	/**
	 * 设置无效
	 * @param companyId
	 * @param cardId
	 * @return
	 */
	public boolean setNotValidate(String companyId, String cardId){
			String time = formatter2.format(new Date());
			cacheFactory.checkInit(companyId, this, time);
			Card c = this.getCard(cardId);
			if(c != null && c.getCompanyId().equals(companyId) && c.getIsBack() == 1 && c.getAllocationStatus() == Card.STATUS_WAIT_USE_ALLOCATION){
				String sql = "update js_visitor_info set is_valid = 0, is_expired = 0, is_back=0,  allocation_status = ? where id = ? and modify_identity = ?";
				int count = this.jdbcTemplate.update(sql, Card.STATUS_FINISHED, cardId, c.getModifyIdentity());
				if(count > 0){
					return true;
				}
			}
			return false;

	}

	/**
	 * 手工分配名片
	 * @param companyId
	 * @param cardId
	 * @param userId
	 * @param operatorId
	 */
	public boolean userAllocationCard(String companyId, String cardId, String userId, String operatorId){
		//synchronized(this){
			String time = formatter2.format(new Date());
			cacheFactory.checkInit(companyId, this, time);
			Card c = this.getCard(cardId);
			if(c != null && c.getAllocationStatus() == Card.STATUS_WAIT_USE_ALLOCATION){
				int i = this.updateCard(cardId, userId, Card.STATUS_USE_ALLOCATIONED, c.getModifyIdentity());
				if(i>0){
					this.cacheFactory.getSubjectUserCache().userAllocationCard(companyId, c, userId);
					this.createCardLog(companyId, cardId, userId, CardLog.ALLOCATION_TYPE_USER, operatorId, new Date());
					c.setAllocationStatus(Card.STATUS_USE_ALLOCATIONED);
					c.setUserId(userId);
					this.allocationListenerService.after(c, true);
					return true;
				}
			}
			return false;
		//}		
	}
	/**
	 * 更新名片信息
	 * @param cardId
	 * @param userId
	 * @param status 人工分配3;系统分配1;高意向名片分配6
	 * @param identity
	 * @return
	 */
	private int updateCard(String cardId, String userId, int status, String identity){
		if(status == Card.STATUS_USE_ALLOCATIONED || status == Card.STATUS_SYSTEM_ALLOCATIONED || status == Card.STATUS_SALE_ALLOCATIONED){
			String sql = "update js_visitor_info set allocation_status = ?, user_id = ?, is_back = 0, is_expired = 0, modify_identity = ?, allocation_time = ? where id = ? and modify_identity= ? ";
			return this.jdbcTemplate.update(sql, status, userId, UUID.randomUUID().toString(), new Date(), cardId, identity);
		}else{
			String sql = "update js_visitor_info set allocation_status = ?, user_id = ?, is_back = 0, is_expired = 0, modify_identity = ? where id = ? and modify_identity= ? ";
			return this.jdbcTemplate.update(sql, status, userId, UUID.randomUUID().toString(), cardId, identity);
		}
	}
	private void createCardLog(String companyId, String cardId, String userId, Integer allocationType, String operatorId, Date time){
		CardLog log = new CardLog();
		log.setAllocationType(allocationType);
		log.setCompanyId(companyId);
		log.setCardId(cardId);
		log.setUserId(userId);
		log.setOperatorUserId(operatorId);
		log.setAllocationTime(time);
		this.cardLogService.save(log);
	}
	public Card getCard(String cardId){

		List<Card> list = visitorInfoMapper.findByCardId(cardId);
		if(list != null && !list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}
	}
	@Override
	public CardRule getCardRule(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<StaffInfoVo> getSaleUser(int companyId, String time, Boolean b) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SchedulingTime> getSchedulingTimes(int companyId, String time) {
		// TODO Auto-generated method stub
		return null;
	}
	private String logUser(List<StaffInfoVo> allocationUsers) {
		
		if(allocationUsers == null)
			return "[]";
		
		if(allocationUsers.size() < 1)
			return "[]";
		
		StringBuffer sb = new StringBuffer();
		for(StaffInfoVo s : allocationUsers) {
			sb.append(s.getStaffId());
			sb.append(",");
		}
		return sb.toString();
	}

}
