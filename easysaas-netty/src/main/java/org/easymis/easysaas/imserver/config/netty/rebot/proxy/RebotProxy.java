package org.easymis.easysaas.imserver.config.netty.rebot.proxy;

import org.easymis.easysaas.imserver.config.netty.DataContent;

public interface RebotProxy {
	/**
	 * 机器人回复
	 * @param receiverId  用于区分回复谁，机器人接口短暂记忆
	 * @param content
	 * @return
	 */
	DataContent botMessageReply(String receiverId ,DataContent  content);
}
