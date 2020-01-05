package org.easymis.easycrm.mobile.security.service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.easymis.easycrm.mobile.security.RegexConstant;
import org.easymis.easycrm.mobile.security.RestResult;
import org.easymis.easycrm.mobile.security.userdetail.User;
import org.easymis.easycrm.mobile.utils.MD5Util;

public interface UserService {

    RestResult getRegShortMessage(@NotBlank @Pattern(regexp = RegexConstant.regexp_phoneNumber, message = "手机号码格式不正确") String phoneNumber);

    RestResult quickReg(@NotBlank @Pattern(regexp = RegexConstant.regexp_phoneNumber, message = "手机号码格式不正确") String phoneNumber, @NotBlank String code, String password);


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