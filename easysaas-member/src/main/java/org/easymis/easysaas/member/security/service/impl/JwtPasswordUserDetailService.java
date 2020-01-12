package org.easymis.easysaas.member.security.service.impl;


import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.easymis.easysaas.common.contant.RegexConstant;
import org.easymis.easysaas.member.entitys.vo.User;
import org.easymis.easysaas.member.security.service.UserRoleService;
import org.easymis.easysaas.member.security.userdetail.ExpireDateGrantedAuthority;
import org.easymis.easysaas.member.security.userdetail.SecurityUserDetails;
import org.easymis.easysaas.member.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service("JwtPasswordUserDetailService")
public class JwtPasswordUserDetailService implements UserDetailsService {


    @Autowired
    UserService userService;


    @Autowired
    UserRoleService  userRoleService;


    private AccountStatusUserDetailsChecker checker =new AccountStatusUserDetailsChecker();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user=null;
        if (Pattern.matches(RegexConstant.regexp_phoneNumber, username)) {
        	user = userService.findByPhoneNumber(username);
        } else if (Pattern.matches(RegexConstant.regexp_email, username)) {
            user = userService.findByEmail(username);
        } else {
            throw new UsernameNotFoundException("请输入手机号码");
        }

        if (Objects.isNull(user)) {
            if (Pattern.matches(RegexConstant.regexp_phoneNumber, username)) {
                return new SecurityUserDetails();
            } else if (Pattern.matches(RegexConstant.regexp_email, username)) {
                throw new UsernameNotFoundException("该账号未注册");
            }
        }
        
        SecurityUserDetails details = new SecurityUserDetails()
                .setId(user.getId())
                .setPassword(user.getPassword())
                .setUsername(user.getName())
                .setUserNo(user.getUserNo())
                .setHeadUrl(user.getHeadUrl())
                .setEmail(user.getEmail())
                .setPhoneNumber(user.getPhoneNumber())
                .setEnabled(user.getEnabled())
                .setSex(user.getSex());
        //----------------------------------------------------------------
        List<ExpireDateGrantedAuthority> authority = userRoleService.getGrantedAuthorityByUserNo(user.getUserNo());
        details.setExpireDateGrantedAuthorityList(authority);
        checker.check(details);
        return details;
    }


    public static void main(String[] args) {
        System.out.print(Pattern.matches(RegexConstant.regexp_phoneNumber, "13489798318"));
    }

}
