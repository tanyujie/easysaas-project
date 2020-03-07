package org.easymis.easysaas.imserver.entitys.mybatis.mapper;

import java.util.List;

import org.easymis.easysaas.imserver.entitys.vo.FriendRequestVO;
import org.easymis.easysaas.imserver.entitys.vo.MyFriendsVO;

public interface UsersMapperCustom  {
	
	public List<FriendRequestVO> queryFriendRequestList(String acceptUserId);
	
	public List<MyFriendsVO> queryMyFriends(String userId);
	
	public void batchUpdateMsgSigned(List<String> msgIdList);
	
}