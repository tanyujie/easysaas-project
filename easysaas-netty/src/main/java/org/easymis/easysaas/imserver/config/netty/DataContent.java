package org.easymis.easysaas.imserver.config.netty;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class DataContent implements Serializable {

	private static final long serialVersionUID = 8021381444738260454L;

	private Integer action;		// 动作类型
	private ChatMsg chatMsg;	// 用户的聊天内容entity
	private String extand;		// 扩展字段
	
	public Integer getAction() {
		return action;
	}
	public void setAction(Integer action) {
		this.action = action;
	}
	public ChatMsg getChatMsg() {
		return chatMsg;
	}
	public void setChatMsg(ChatMsg chatMsg) {
		this.chatMsg = chatMsg;
	}
	public String getExtand() {
		return extand;
	}
	public void setExtand(String extand) {
		this.extand = extand;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataContent dc= new DataContent();
		dc.setAction(1);
		ChatMsg chatMsg = new ChatMsg();
		chatMsg.setMsg("消息");
		chatMsg.setMsgId("msgId");
		chatMsg.setReceiverId("receiverId");
		chatMsg.setSenderId("senderId");
		dc.setChatMsg(chatMsg);
		dc.setExtand("orgId");
		
		String str = JSON.toJSONString(dc);
		System.out.print(str);
	}
}
