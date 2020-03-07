package org.easymis.easysaas.netty.service.impl;

import org.easymis.easysaas.netty.entitys.mybatis.dto.Member;
import org.easymis.easysaas.netty.entitys.mybatis.mapper.MemberMapper;
import org.easymis.easysaas.netty.n3r.idworker.Sid;
import org.easymis.easysaas.netty.service.MemberService;
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
}
