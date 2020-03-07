package org.easymis.easysaas.netty.entitys.mybatis.mapper;

import java.util.List;

import org.easymis.easysaas.netty.entitys.mybatis.dto.ChatMsg;

public interface ChatMsgMapper {
	int insertByBean(ChatMsg bean);

	List<ChatMsg> find(Integer signFlag, String acceptUserId);
}
