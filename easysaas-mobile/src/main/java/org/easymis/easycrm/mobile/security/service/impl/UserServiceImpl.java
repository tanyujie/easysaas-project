package org.easymis.easycrm.mobile.security.service.impl;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.easymis.easycrm.mobile.entitys.mybatis.mapper.UserMapper;
import org.easymis.easycrm.mobile.security.RestResult;
import org.easymis.easycrm.mobile.security.service.UserService;
import org.easymis.easycrm.mobile.security.userdetail.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper mapper;
	@Override
	public RestResult getRegShortMessage(
			@NotBlank @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号码格式不正确") String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult quickReg(
			@NotBlank @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号码格式不正确") String phoneNumber,
			@NotBlank String code, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User quickReg(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult changePasswordByOldpwd(String oldpwd, @NotBlank(message = "新密码不能为空") String newpwd,
			String identityFeature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult changePasswordBySmsCode(String smscode, @NotBlank(message = "新密码不能为空") String newpwd,
			String identityFeature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return mapper.findByPhoneNumber(phoneNumber);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return mapper.findByEmail(email);
	}

	@Override
	public User findByUserno(String userno) {
		// TODO Auto-generated method stub
		return mapper.findByUserno(userno);
	}

}
