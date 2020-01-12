package org.easymis.easysaas.member.controller;


import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.easymis.easysaas.common.contant.RegexConstant;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.member.entitys.mybatis.dto.Member;
import org.easymis.easysaas.member.service.UserService;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(description = "注册与发送接口")
@RestController
@RequestMapping("/register")
@Validated
@Valid 
public class SecurityUserController {

    @Autowired
    UserService userService;
    
    
    @ApiOperation("快速注册 ,发送验证码")
    @PostMapping("sendSmsCode")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "phoneNumber", value = "手机号码", dataType = "string", required = true),
        @ApiImplicitParam(name = "sendType", value = "发送类型:1注册验证码2登录验证码3找回密码验证码", dataType = "Integer", required = true)
    })

    public RestResult sendRegSmsCode(@NotBlank @Pattern(regexp = RegexConstant.regexp_phoneNumber, message = "手机号码格式不正确") String mobile,
    		@NotNull(message = "id不能为空")@Range(min = 1, max = 3, message = "发送类型不合法，请检查")Integer sendType) {
        RestResult result =null ;
        Member user = userService.findByMobile(mobile);
        if(sendType==1) {
            if(Objects.isNull(user)){
                result = userService.getRegisterShortMessage(mobile);
            }else{
                result = RestResult.buildFail("手机号码已经被注册");
            }
        }else if(sendType==2) {
            if(Objects.isNull(user)){
                result = RestResult.buildFail("手机号码未注册");
            }else{
                result = userService.getLoginShortMessage(mobile);
            }
        }else if(sendType==3) {
            if(Objects.isNull(user)){
                result = RestResult.buildFail("手机号码未注册");
            }else{
                result = userService.getForgitPasswordShortMessage(mobile);
            }
        	
        }
        return result;
    }


    @ApiOperation("快速注册")
    @PostMapping("quickRegister")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phoneNumber", value = "手机号码", dataType = "string", required = true),
            @ApiImplicitParam(name = "code", value = "验证码", dataType = "string", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string", required = true)
    })
    public RestResult quickReg(@NotBlank @Pattern(regexp = RegexConstant.regexp_phoneNumber, message = "手机号码格式不正确") String phoneNumber,
                               @NotBlank(message = "请输入手机验证码") String code,
                               @NotBlank(message = "请输入密码")@Length(min=32,message = "请输入有效密码") String password) {
        RestResult result = userService.quickRegister(phoneNumber, code, password);
        return result;
    }


    @ApiOperation("修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldpwd", value = "旧密码", required = false, dataType = "string"),
            @ApiImplicitParam(name = "newpwd", value = "新密码", required = false, dataType = "string"),
            @ApiImplicitParam(name = "smscode", value = "短信验证码", required = false, dataType = "string"),
            @ApiImplicitParam(name = "phoneNumber", value = "手机号码", required = true, dataType = "string")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")

    })
    @PostMapping("changePassword")
    public RestResult changePassword(String oldpwd, @NotBlank(message = "新密码不能为空")
    @Length(min=32,message = "请输入有效密码") String newpwd, @NotBlank(message = "手机验证码不能为空") String smscode, @NotBlank(message = "手机号码不能为空") String phoneNumber) {
        if (StringUtils.isNotEmpty(oldpwd)) {
            return userService.updatePasswordByOldPassword(oldpwd, newpwd, phoneNumber);
        } else if (StringUtils.isNotEmpty(smscode)) {
            return userService.updatePasswordByShortMessage(smscode, newpwd, phoneNumber);
        } else {
            return RestResult.buildFail("缺少必要参数");
        }
    }
    

}
