package org.easymis.easysaas.crm.controller;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.common.utils.MD5Util;
import org.easymis.easysaas.crm.config.JwtTokenUtil;
import org.easymis.easysaas.crm.entitys.mybatis.dto.Member;
import org.easymis.easysaas.crm.entitys.vo.LoginOto;
import org.easymis.easysaas.crm.entitys.vo.LoginVo;
import org.easymis.easysaas.crm.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;


@Api(description = "系统登录")
@Validated
@RestController
@Slf4j
public class LoginController {



	@Autowired
	private MemberService userRepository;
    //
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public RestResult login(LoginVo ar) {
		
		
		Member member=userRepository.findByMobile(ar.getUsername());
		if(member!=null) {
			System.out.println(MD5Util.md5(ar.getPassword()));
			if (MD5Util.md5(ar.getPassword()).equals(member.getPassword())) {
				LoginOto loginOto= new LoginOto();
				loginOto.setEasysaasToken(JwtTokenUtil.generateToken(member.getMemberId(),"2016110202340575"));
		        return RestResult.buildSuccess(loginOto);
			} else {
				return RestResult.buildFail("密码错误");
			}
		}		
		return RestResult.buildFail();
	}

}
