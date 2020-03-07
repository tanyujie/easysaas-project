package org.easymis.easysaas.imserver.entitys.mybatis.mapper;

import java.util.List;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.ChatMsg;

public interface ChatMsgMapper {
	int insertByBean(ChatMsg bean);

	List<ChatMsg> find(Integer signFlag, String acceptUserId);
}
