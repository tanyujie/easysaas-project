package org.easymis.easysaas.imserver.config.netty;

import java.io.Serializable;

public class ChatMsg implements Serializable {

	private static final long serialVersionUID = 3611169682695799175L;
	private String orgId;//
	private String groupId;//群id
	private String senderId; // 发送者的用户id
	private String receiverId; // 接受者的用户id
	private String msg; // 聊天内容
	private String msgId; // 用于消息的签收

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
