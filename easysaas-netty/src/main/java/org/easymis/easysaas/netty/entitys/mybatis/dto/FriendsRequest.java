package org.easymis.easysaas.netty.entitys.mybatis.dto;

import java.util.Date;

public class FriendsRequest {

	private String id;

	private String sendUserId;

	private String acceptUserId;

	private Date requestDateTime;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 *
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return send_user_id
	 */
	public String getSendUserId() {
		return sendUserId;
	}

	/**
	 *
	 */
	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}

	/**
	 * @return accept_user_id
	 */
	public String getAcceptUserId() {
		return acceptUserId;
	}

	/**
	 *
	 */
	public void setAcceptUserId(String acceptUserId) {
		this.acceptUserId = acceptUserId;
	}

	/**
	 * @return request_date_time
	 */
	public Date getRequestDateTime() {
		return requestDateTime;
	}

	/**
	 *
	 */
	public void setRequestDateTime(Date requestDateTime) {
		this.requestDateTime = requestDateTime;
	}
}
