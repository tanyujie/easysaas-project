package org.easymis.easysaas.netty.entitys.mybatis.mapper;

import org.easymis.easysaas.netty.entitys.mybatis.dto.MyFriends;

public interface MyFriendsMapper {
	int insertByBean(MyFriends bean);
	
	
	
	MyFriends find(String myUserId,String myFriendUserId);
}
