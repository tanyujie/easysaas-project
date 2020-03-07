package org.easymis.easysaas.imserver.entitys.mybatis.mapper;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.FriendsRequest;

public interface FriendsRequestMapper {
	int insertByBean(FriendsRequest bean);
	FriendsRequest find(String sendUserId,String acceptUserId);

	void delete(String sendUserId,String acceptUserId);
}
