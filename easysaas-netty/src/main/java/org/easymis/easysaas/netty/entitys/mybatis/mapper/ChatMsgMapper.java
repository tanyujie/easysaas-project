package org.easymis.easysaas.netty.entitys.mybatis.mapper;

import org.easymis.easysaas.netty.entitys.mybatis.dto.ChatMsg;

public interface ChatMsgMapper {
	int insertByBean(ChatMsg bean);
}
