package org.easymis.easysaas.imserver.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.imserver.entitys.vo.FriendRequestVO;
import org.easymis.easysaas.imserver.entitys.vo.MyFriendsVO;

public interface UsersMapperCustom  {
	
	public List<FriendRequestVO> queryFriendRequestList(String acceptUserId);
	 @Select("select t.friend_id as friendUserId,m.name as friendNickname "
	 		+ "from my_friends t left join member m on t.friend_id=m.member_id "
	 		+ "WHERE t.member_id=#{memberId}")  
	public List<MyFriendsVO> queryMyFriends(String memberId);
	@Update({"<script>",
        "update chat_msg set sign_flag=1",
        "WHERE id IN", 
          "<foreach item='item' index='index' collection='msgIds'",
            "open='(' separator=',' close=')'>",
            "#{item}",
          "</foreach>",
        "</script>"}) 
	public void batchUpdateMsgSigned(@Param("msgIds") List<String> msgIds);
	
}