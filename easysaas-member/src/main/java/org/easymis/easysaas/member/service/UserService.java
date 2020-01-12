package org.easymis.easysaas.member.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.common.utils.MD5Util;
import org.easymis.easysaas.member.entitys.mybatis.dto.Member;
import org.easymis.easysaas.member.security.userdetail.User;

import reactor.core.publisher.Mono;


public interface UserService {
	Mono<User> findByUsername(String username);

	Member findByMobile(String mobile);

	Member findByEmail(String email);

	RestResult getRegisterShortMessage(String mobile);

	RestResult getLoginShortMessage(String mobile);

	RestResult getForgitPasswordShortMessage(String mobile);

	Member quickRegister(String phoneNumber);

	RestResult quickRegister(String mobile, String code, String password);

	RestResult updatePasswordByOldPassword(String oldpwd, String newpwd, String identityFeature);

	RestResult updatePasswordByShortMessage(String smscode, String newpwd, String identityFeature);

	default String generateUserNo(String phoneNumber) {
		DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");
		String now = LocalDate.now().format(yyyyMMdd);
		return "GDE" + now + phoneNumber;
	}

	default String generateUsername() {
		char[] pool = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
				'j', 'k', 'l', 'q', 'w', 't', 'y', 'u', 'i', 'o', 'p', 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
		char[] chars = new char[10];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = pool[new Random().nextInt(pool.length - 1) + 1];
		}

		return "GDE" + new String(chars);
	}

	default String generatePassword() {
		char[] pool = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
				'j', 'k', 'l', 'q', 'w', 't', 'y', 'u', 'i', 'o', 'p', 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
		char[] chars = new char[16];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = pool[new Random().nextInt(pool.length - 1) + 1];
		}

		return MD5Util.md5(new String(chars));

	}
}
