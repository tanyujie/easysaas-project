package org.easymis.easycrm.common.security.controller;


import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.easymis.easycrm.common.security.RegexConstant;
import org.easymis.easycrm.common.security.RestResult;
import org.easymis.easycrm.common.security.service.UserService;
import org.easymis.easycrm.common.security.userdetail.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/sec")
@Validated
public class SecurityUserController {

    @Autowired
    UserService userService;

    @ApiOperation("快速注册 ,发送验证码")
    @PostMapping("sendRegSmsCode")
    @ApiImplicitParam(name = "phoneNumber", value = "手机号码", dataType = "string", required = true)
    public RestResult sendRegSmsCode(@NotBlank @Pattern(regexp = RegexConstant.regexp_phoneNumber, message = "手机号码格式不正确") String phoneNumber) {
        RestResult result = userService.getRegShortMessage(phoneNumber);
        return result;
    }


    @ApiOperation("快速注册 ,发送验证码 包含校验手机号码是否有注册过")
    @PostMapping("sendRegSmsCode2")
    @ApiImplicitParam(name = "phoneNumber", value = "手机号码", dataType = "string", required = true)
    public RestResult sendRegSmsCode2(@NotBlank @Pattern(regexp = RegexConstant.regexp_phoneNumber, message = "手机号码格式不正确") String phoneNumber) {
        User user = null;//userService.getOne(new QueryWrapper<User>().lambda().eq(User::getPhoneNumber, phoneNumber));
        RestResult result =null ;
        if(Objects.isNull(user)){
            result = userService.getRegShortMessage(phoneNumber);
        }else{
            result = RestResult.buildFail("手机号码已经被注册");
        }
        return result;
    }

    @ApiOperation("快速注册")
    @PostMapping("quickReg")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phoneNumber", value = "手机号码", dataType = "string", required = true),
            @ApiImplicitParam(name = "code", value = "验证码", dataType = "string", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string", required = true)
    })
    public RestResult quickReg(@NotBlank @Pattern(regexp = RegexConstant.regexp_phoneNumber, message = "手机号码格式不正确") String phoneNumber,
                               @NotBlank(message = "请输入手机验证码") String code,
                               @NotBlank(message = "请输入密码")@Length(min=32,message = "请输入有效密码") String password) {
        RestResult result = userService.quickReg(phoneNumber, code, password);
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
            return userService.changePasswordByOldpwd(oldpwd, newpwd, phoneNumber);
        } else if (StringUtils.isNotEmpty(smscode)) {
            return userService.changePasswordBySmsCode(smscode, newpwd, phoneNumber);
        } else {
            return RestResult.buildFail("缺少必要参数");
        }
        //return RestResult.buildSuccess();
    }
}
