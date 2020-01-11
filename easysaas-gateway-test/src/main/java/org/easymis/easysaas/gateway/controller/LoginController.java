package org.easymis.easysaas.gateway.controller;

import org.easymis.easysaas.gateway.model.AuthRequest;
import org.easymis.easysaas.gateway.model.AuthResponse;
import org.easymis.easysaas.gateway.model.RestResult;
import org.easymis.easysaas.gateway.model.User;
import org.easymis.easysaas.gateway.security.JWTUtil;
import org.easymis.easysaas.gateway.security.PBKDF2Encoder;
import org.easymis.easysaas.gateway.service.UserService;
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
	private JWTUtil jwtUtil;
	
	@Autowired
	private PBKDF2Encoder passwordEncoder;

	@Autowired
	private UserService userRepository;
    //
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public RestResult login(AuthRequest ar) {
		User userDetails=userRepository.findByMobile(ar.getUsername());
		if(userDetails!=null) {
			if (passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword())) {
				return RestResult.buildSuccess(new AuthResponse(jwtUtil.generateToken(userDetails),ar.getUsername()));
			} else {
				return RestResult.buildFail("密码错误");
			}
		}		
		return RestResult.buildFail();
	}
/*	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Mono<ResponseEntity<?>> login( @RequestBody  AuthRequest ar) {
		return userRepository.findByUsername(ar.getUsername()).map((userDetails) -> {
			if (passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword())) {
				return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails),ar.getUsername()));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}*/
}
