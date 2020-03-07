package org.easymis.easysaas.imserver.service.impl;

import java.util.List;

import org.easymis.easysaas.imserver.config.netty.ChatMsg;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.Member;
import org.easymis.easysaas.imserver.entitys.mybatis.mapper.MemberMapper;
import org.easymis.easysaas.imserver.entitys.vo.FriendRequestVO;
import org.easymis.easysaas.imserver.entitys.vo.MyFriendsVO;
import org.easymis.easysaas.imserver.n3r.idworker.Sid;
import org.easymis.easysaas.imserver.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper userMapper;

	@Autowired
	private Sid sid;

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean queryUsernameIsExist(String phoneNumber) {
		Member result = userMapper.findByPhoneNumber(phoneNumber);
		return result != null;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Member queryUserForLogin(String phoneNumber, String pwd) {
		Member result = userMapper.get(phoneNumber,pwd);
		return result;
	}

	@Override
	public Member saveUser(Member user) {
		String userId = sid.nextShort();
		// TODO
		user.setQrcode("");
		user.setId(userId);
		userMapper.insertByBean(user);
		return user;
	}

	@Override
	public Member updateUserInfo(Member user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer preconditionSearchFriends(String myUserId, String friendUsername) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member queryUserInfoByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendFriendRequest(String myUserId, String friendUsername) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FriendRequestVO> queryFriendRequestList(String acceptUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFriendRequest(String sendUserId, String acceptUserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passFriendRequest(String sendUserId, String acceptUserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MyFriendsVO> queryMyFriends(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveMsg(ChatMsg chatMsg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMsgSigned(List<String> msgIdList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<org.easymis.easysaas.imserver.entitys.mybatis.dto.ChatMsg> getUnReadMsgList(String acceptUserId) {
		// TODO Auto-generated method stub
		return null;
	}
}
