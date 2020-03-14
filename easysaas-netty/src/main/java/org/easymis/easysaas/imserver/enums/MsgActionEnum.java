package org.easymis.easysaas.imserver.enums;

/**
 * 
 * @Description: 发送消息的动作 枚举（可分为系统消息，基础消息，业务消息，第三方消息）
 */
public enum MsgActionEnum {
	
	CONNECT(1, "第一次(或重连)初始化连接"),
	CHAT(2, "聊天消息"),
	//照片，拍摄，视频通话，位置，红包，转账，语音输入，收藏，个人名片，文件，卡券
	//文字，语音，相册，拍摄，短视频，视频通话，红包，钉盘,ding,任务，日程，密聊，钉邮，名片，收藏，位置，签到，日志，审批，企业主页，文件，语音输入
	TEXT(21, "文字消息"),	
	emoji(22,"表情包"),
	picture(23, "图片消息"),
	voice(24, "语音消息"),
	FaceTime(25, "视频通话"),
	
	SIGNED(3, "消息签收"),
	KEEPALIVE(4, "客户端保持心跳"),
	PULL_FRIEND(5, "拉取好友");
	
	public final Integer type;
	public final String content;
	
	MsgActionEnum(Integer type, String content){
		this.type = type;
		this.content = content;
	}
	
	public Integer getType() {
		return type;
	}  
}
