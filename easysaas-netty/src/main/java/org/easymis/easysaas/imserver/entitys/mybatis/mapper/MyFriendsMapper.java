package org.easymis.easysaas.imserver.entitys.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.MyFriends;

public interface MyFriendsMapper {
	int insertByBean(MyFriends bean);
	
	
	@Select("<script>" + "SELECT * FROM my_friends WHERE member_id=#{memberId} and friend_id=#{friendId}" + "</script>")
	MyFriends find(@Param("memberId") String memberId,@Param("friendId") String friendId);
}
