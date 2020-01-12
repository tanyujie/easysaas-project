package org.easymis.easysaas.member.service;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.member.entitys.mybatis.dto.Member;
import org.easymis.easysaas.member.entitys.vo.User;
import org.hibernate.validator.constraints.NotBlank;

import reactor.core.publisher.Mono;


public interface UserService {
	public Mono<User> findByUsername(String username);	
	public Member findByMobile(String mobile);	
    RestResult getRegisterShortMessage(String mobile);
    RestResult getLoginShortMessage(String mobile);
    RestResult getForgitPasswordShortMessage(String mobile);
    RestResult quickRegister(String mobile, String code, String password);
    RestResult updatePasswordByOldPassword(String oldpwd, String newpwd, String identityFeature);

    RestResult updatePasswordByShortMessage(String smscode, String newpwd, String identityFeature);

	
}
