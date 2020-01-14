package org.easymis.easysaas.gateway.service.impl;

import java.util.Arrays;

import org.easymis.easysaas.gateway.config.datasource.DataSourceType;
import org.easymis.easysaas.gateway.config.datasource.EasymisDataSource;
import org.easymis.easysaas.gateway.entitys.mybatis.dto.Member;
import org.easymis.easysaas.gateway.entitys.mybatis.dto.Role;
import org.easymis.easysaas.gateway.entitys.mybatis.mapper.UserMapper;
import org.easymis.easysaas.gateway.entitys.vo.User;
import org.easymis.easysaas.gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper mapper;
/*	//username:passwowrd -> 13551259347:123456
	private final String userUsername = "13551259347";// password: 123456
	private final User user = new User(userUsername, "fV8G3g4M7OgyajhE/BcbHL69JAZfDlU5+ihrxO5wBi0=", true, Arrays.asList(Role.ROLE_USER));
	
	//username:passwowrd -> admin:admin
	private final String adminUsername = "admin";// password: admin
	private final User admin = new User(adminUsername, "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=", true, Arrays.asList(Role.ROLE_ADMIN));
	*/
	public Mono<User> findByUsername(String username) {
/*		if (username.equals(userUsername)) {
			return Mono.just(user);
		} else if (username.equals(adminUsername)) {
			return Mono.just(admin);
		} else {
			return Mono.empty();
		}*/
		return Mono.empty();
	}

	@EasymisDataSource(DataSourceType.Master)
	public Member findByMobile(String mobile) {
		return mapper.findByPhoneNumber(mobile);
	}

	@Override
	public Member findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member saveQuickRegister(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}
