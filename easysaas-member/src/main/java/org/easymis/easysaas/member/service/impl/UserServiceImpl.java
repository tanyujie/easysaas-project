package org.easymis.easysaas.member.service.impl;

import java.util.Arrays;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.member.config.datasource.DataSourceType;
import org.easymis.easysaas.member.config.datasource.EasymisDataSource;
import org.easymis.easysaas.member.entitys.mybatis.dto.Member;
import org.easymis.easysaas.member.entitys.mybatis.mapper.UserMapper;
import org.easymis.easysaas.member.entitys.vo.Role;
import org.easymis.easysaas.member.entitys.vo.User;
import org.easymis.easysaas.member.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper mapper;
	//username:passwowrd -> 13551259347:123456
	private final String userUsername = "13551259347";// password: 123456
	private final User user = new User(userUsername, "fV8G3g4M7OgyajhE/BcbHL69JAZfDlU5+ihrxO5wBi0=", true, Arrays.asList(Role.ROLE_USER));
	
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

	@EasymisDataSource(DataSourceType.Master)
	public Member findByMobile(String mobile) {
		return mapper.findByPhoneNumber(mobile);
	}

	@EasymisDataSource(DataSourceType.Master)
	public RestResult getRegisterShortMessage(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@EasymisDataSource(DataSourceType.Master)
	public RestResult getLoginShortMessage(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@EasymisDataSource(DataSourceType.Master)
	public RestResult getForgitPasswordShortMessage(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@EasymisDataSource(DataSourceType.Master)
	public RestResult quickRegister(String mobile, String code, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@EasymisDataSource(DataSourceType.Master)
	public RestResult updatePasswordByOldPassword(String oldpwd, String newpwd, String identityFeature) {
		// TODO Auto-generated method stub
		return null;
	}

	@EasymisDataSource(DataSourceType.Master)
	public RestResult updatePasswordByShortMessage(String smscode, String newpwd, String identityFeature) {
		// TODO Auto-generated method stub
		return null;
	}
}
