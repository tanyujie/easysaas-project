package org.easymis.easysaas.gateway.security.controller;

import javax.validation.Valid;

import org.easymis.easysaas.common.result.RestResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(description = "注册与发送接口")
@RestController
@RequestMapping("/test")
@Validated
@Valid 
public class Test {
	@PostMapping("changePassword")
	public RestResult changePassword() {
		return RestResult.buildFail("缺少必要参数");
	}
}
