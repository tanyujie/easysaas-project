package org.easymis.easysaas.gateway.security.service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.sharepanzer.companydata.common.contant.RegexConstant;
import com.sharepanzer.companydata.common.result.RestResult;
import com.sharepanzer.companydata.common.utils.MD5Util;
import org.easymis.easysaas.gateway.security.userdetail.User;


public interface UserService {

    RestResult getRegShortMessage(@NotBlank @Pattern(regexp = RegexConstant.regexp_phoneNumber, message = "手机号码格式不正确") String phoneNumber);
    RestResult getLoginShortMessage(@NotBlank @Pattern(regexp = RegexConstant.regexp_phoneNumber, message = "手机号码格式不正确") String phoneNumber);
    RestResult sendForgitPasswordSmsCode(@NotBlank @Pattern(regexp = RegexConstant.regexp_phoneNumber, message = "手机号码格式不正确") String phoneNumber);
    RestResult quickReg(@NotBlank @Pattern(regexp = RegexConstant.regexp_phoneNumber, message = "手机号码格式不正确") String phoneNumber, @NotBlank String code, String password);

    void updatePassword(User user);
    User quickReg(String phoneNumber);

    RestResult changePasswordByOldpwd(String oldpwd, @NotBlank(message = "新密码不能为空") String newpwd, String identityFeature);

    RestResult changePasswordBySmsCode(String smscode, @NotBlank(message = "新密码不能为空") String newpwd, String identityFeature);

    default String generateUserNo(String phoneNumber) {
        DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = LocalDate.now().format(yyyyMMdd);
        return "GDE" + now + phoneNumber;
    }

    default  String  generateUsername(){
        char[] pool = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'q', 'w', 't', 'y', 'u', 'i', 'o', 'p', 'z'
                , 'x', 'c', 'v', 'b', 'n', 'm'};
        char[] chars = new char[10];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = pool[new Random().nextInt(pool.length-1) + 1];
        }

        return "GDE"+new String(chars);
    }


    default  String generatePassword(){
      char[] pool = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'q', 'w', 't', 'y', 'u', 'i', 'o', 'p', 'z'
                , 'x', 'c', 'v', 'b', 'n', 'm'};
        char[] chars = new char[16];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = pool[new Random().nextInt(pool.length-1) + 1];
        }

        return MD5Util.md5(new String(chars));

    }
    User findByUserno(String userno);
    User findByPhoneNumber(String phoneNumber);
    User findByEmail(String email);
}