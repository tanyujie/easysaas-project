package org.easymis.easysaas.gateway.service.impl;

import java.util.Arrays;

import org.easymis.easysaas.gateway.model.Role;
import org.easymis.easysaas.gateway.model.User;
import org.easymis.easysaas.gateway.service.UserService;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
@Service
public class UserServiceImpl implements UserService {

	//username:passwowrd -> user:user
	private final String userUsername = "user";// password: user
	private final User user = new User(userUsername, "cBrlgyL2GI2GINuLUUwgojITuIufFycpLG4490dhGtY=", true, Arrays.asList(Role.ROLE_USER));
	
	//username:passwowrd -> admin:admin
	private final String adminUsername = "admin";// password: admin
	private final User admin = new User(adminUsername, "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=", true, Arrays.asList(Role.ROLE_ADMIN));
	
	public Mono<User> findByUsername(String username) {
		if (username.equals(userUsername)) {
			return Mono.just(user);
		} else if (username.equals(adminUsername)) {
			return Mono.just(admin);
		} else {
			return Mono.empty();
		}
	}

	@Override
	public User findByMobile(String mobile) {
		if (mobile.equals(userUsername)) {
			return user;
		}
		return admin;
	}
}
