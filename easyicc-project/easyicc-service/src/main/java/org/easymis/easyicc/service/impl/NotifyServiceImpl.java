package org.easymis.easyicc.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.easymis.easyicc.service.NotifyService;
import org.springframework.stereotype.Service;
@Service  
public class NotifyServiceImpl implements NotifyService {
	private Map<String, Date> lastLoadTimes = new HashMap<String, Date>();
	private Map<String, Map<String, NotifyUser>> cache = new HashMap<String, Map<String, NotifyUser>>();
	@Override
	public void clearNotifyTime(String orgId, String staffId) {
		NotifyUser user = this.getNotifyUser(orgId, staffId);
		if(user != null){
			user.clearNotifyTime();
		}
		
	}
	private void init(String orgId){
		Date date = this.lastLoadTimes.get(orgId);
		Date now = new Date();
		if(date == null || now.getTime() - date.getTime() > 120*1000){
			this.lastLoadTimes.put(orgId, now);
			Map<String, NotifyUser> notifyUsers = this.cache.get(orgId);
			if(notifyUsers == null){
				notifyUsers = new HashMap<String, NotifyUser>();
				this.cache.put(orgId, notifyUsers);
			}
			List<String> userIds = this.getUserId(orgId);
			Set<String> notExists = new HashSet<String>();
			notExists.addAll(notifyUsers.keySet());
			for(String userId : userIds){
				if(notExists.contains(userId)){
					notExists.remove(userId);
				}else{
					NotifyUser user = new NotifyUser(userId);
					notifyUsers.put(userId, user);
				}
			}
			for(String userId : notExists){
				notifyUsers.remove(userId);
			}
		}
	}
	private List<String> getUserId(String companyId){
		String sql = "select a.user_id from js_user a "+
					"	where a.company_id = ? and exists( "+
					"	      select 1 from js_user_role b "+
					"	      inner join js_sys_role_menu c on b.role_id = c.role_id "+
					"	      where a.user_id = b.user_id and (b.role_id = 'ADMIN_ROLE' or c.menu_id = 'cuour.setting.allocation.index') "+
					"	)";
		//return this.jdbcTemplate.query(sql, new Object[]{companyId}, new RowMapper<String>(){
		//	@Override
		//	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		//		return rs.getString("user_id");
		//	}
		//});
	return null;
	}
	private NotifyUser getNotifyUser(String orgId, String staffId){
		synchronized(this){
			this.init(orgId);
			return this.cache.get(orgId).get(staffId);
		}
	}
	class NotifyUser{
		
		private String userId;
		
		private Date lastNotifyTime;
		
		public NotifyUser(String userId){
			this.userId = userId;
		}
		
		public void clearNotifyTime(){
			this.lastNotifyTime = null;
		}
		
		public void setNotifyTime(){
			this.lastNotifyTime = new Date();
		}

		public String getUserId() {
			return userId;
		}

		public Date getLastNotifyTime() {
			return lastNotifyTime;
		}
		
	}
}
