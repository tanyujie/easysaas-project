package org.easymis.easysaas.gateway.security.service;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.easymis.easysaas.common.contant.RegexConstant;
import org.easymis.easysaas.gateway.entitys.mybatis.dto.Member;
import org.easymis.easysaas.gateway.security.userdetail.ExpireDateGrantedAuthority;
import org.easymis.easysaas.gateway.security.userdetail.SecurityUserDetails;
import org.easymis.easysaas.gateway.service.UserRoleService;
import org.easymis.easysaas.gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class JwtPasswordUserDetailService implements ReactiveUserDetailsService {
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService  userRoleService;
    private AccountStatusUserDetailsChecker checker =new AccountStatusUserDetailsChecker();
    @Override
    public Mono<UserDetails> findByUsername(String username) throws UsernameNotFoundException{
    	Member member=null;
        if (Pattern.matches(RegexConstant.regexp_phoneNumber, username)) {
        	member = userService.findByMobile(username);
        } else if (Pattern.matches(RegexConstant.regexp_email, username)) {
        	member = userService.findByEmail(username);
        } else {
            throw new UsernameNotFoundException("请输入手机号码");
        }
        if (Objects.isNull(member)) {
            if (Pattern.matches(RegexConstant.regexp_phoneNumber, username)) {
            	return Mono.error(new UsernameNotFoundException("User Not Found"));
                //return new SecurityUserDetails(); 需要优化
            } else if (Pattern.matches(RegexConstant.regexp_email, username)) {
                throw new UsernameNotFoundException("该账号未注册");
            }
        }
        SecurityUserDetails details = new SecurityUserDetails()
                .setId(member.getId())
                .setPassword(member.getPassword())
                .setUsername(member.getName())
                .setUserNo(member.getUserNo())
                .setHeadUrl(member.getHeadUrl())
                .setEmail(member.getEmail())
                .setPhoneNumber(member.getPhoneNumber())
                .setEnabled(member.getEnabled())
                .setSex(member.getSex());
        //----------------------------------------------------------------
        List<ExpireDateGrantedAuthority> authority = userRoleService.getGrantedAuthorityByUserNo(member.getUserNo());
        details.setExpireDateGrantedAuthorityList(authority);
        checker.check(details);
        return Mono.just(details);

    }



}
