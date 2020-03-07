package org.easymis.easysaas.imserver.entitys.mybatis.mapper;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.MyFriends;

public interface MyFriendsMapper {
	int insertByBean(MyFriends bean);
	
	
	
	MyFriends find(String myUserId,String myFriendUserId);
}
