package org.easymis.easyicc.domain.entity;

import java.util.Date;

public class ApiPushLog extends VisitorInfo{
	   private Integer pushCount ;
	    
	    private String responseStr ;
	    
		private Date firsrErrorTime ;
	    
	    private Date pushTime ;
	    
	    private Date latErrorTime ;
	    
	    private Integer status ;


		private String cardId ;


		public Integer getPushCount() {
			return pushCount;
		}


		public void setPushCount(Integer pushCount) {
			this.pushCount = pushCount;
		}


		public String getResponseStr() {
			return responseStr;
		}


		public void setResponseStr(String responseStr) {
			this.responseStr = responseStr;
		}


		public Date getFirsrErrorTime() {
			return firsrErrorTime;
		}


		public void setFirsrErrorTime(Date firsrErrorTime) {
			this.firsrErrorTime = firsrErrorTime;
		}


		public Date getPushTime() {
			return pushTime;
		}


		public void setPushTime(Date pushTime) {
			this.pushTime = pushTime;
		}


		public Date getLatErrorTime() {
			return latErrorTime;
		}


		public void setLatErrorTime(Date latErrorTime) {
			this.latErrorTime = latErrorTime;
		}


		public Integer getStatus() {
			return status;
		}


		public void setStatus(Integer status) {
			this.status = status;
		}


		public String getCardId() {
			return cardId;
		}


		public void setCardId(String cardId) {
			this.cardId = cardId;
		}
		
}
