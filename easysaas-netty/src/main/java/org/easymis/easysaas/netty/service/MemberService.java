package org.easymis.easysaas.netty.service;

import org.easymis.easysaas.netty.entitys.mybatis.dto.Member;

public interface  MemberService {
	boolean queryUsernameIsExist(String username);

	Member queryUserForLogin(String usename, String pwd);

	Member saveUser(Member user);
}
