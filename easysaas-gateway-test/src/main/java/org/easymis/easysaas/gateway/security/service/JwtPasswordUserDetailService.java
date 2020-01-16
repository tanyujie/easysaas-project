package org.easymis.easysaas.gateway.security.service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

import org.easymis.easysaas.common.contant.RegexConstant;
import org.easymis.easysaas.gateway.entitys.mybatis.dto.Member;
import org.easymis.easysaas.gateway.entitys.mybatis.dto.Permission;
import org.easymis.easysaas.gateway.security.userdetail.ExpireDateGrantedAuthority;
import org.easymis.easysaas.gateway.security.userdetail.SecurityUserDetails;
import org.easymis.easysaas.gateway.service.MemberService;
import org.easymis.easysaas.gateway.service.PermissionService;
import org.easymis.easysaas.gateway.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;
/**
自定义用户信息获取方式
获取用户信息的接口定义是：ReactiveUserDetailsService
 */
@Component("JwtPasswordUserDetailService")
public class JwtPasswordUserDetailService implements ReactiveUserDetailsService {
    @Autowired
    MemberService memberService;
    @Autowired
    UserRoleService  userRoleService;
    @Autowired
    PermissionService  permissionService;
    
    private AccountStatusUserDetailsChecker checker =new AccountStatusUserDetailsChecker();
    @Override
    public Mono<UserDetails> findByUsername(String username) throws UsernameNotFoundException{
    	Member member=null;
        if (Pattern.matches(RegexConstant.regexp_phoneNumber, username)) {
        	member = memberService.findByMobile(username);
        } else if (Pattern.matches(RegexConstant.regexp_email, username)) {
        	member = memberService.findByEmail(username);
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
                .setMemberId(member.getMemberId())
                .setPassword(member.getPassword())
                .setUsername(member.getName())
                .setMemberNo(member.getMemberNo())
                .setHeadUrl(member.getHeadUrl())
                .setEmail(member.getEmail())
                .setPhoneNumber(member.getPhoneNumber())
                .setEnabled(member.getEnabled())
                .setSex(member.getSex());
        //----------------------------------------------------------------
        List<ExpireDateGrantedAuthority> authority = userRoleService.getGrantedAuthorityByMemberId(member.getMemberNo());
        details.setExpireDateGrantedAuthorityList(authority);
        checker.check(details);
        return Mono.just(details);

    }

	public Boolean checkUrlPermission(String memberId, String url) {
		List<Permission> permissionList = permissionService.findByMemberId(memberId);
		Set<String> permissionSet = new HashSet();
		Boolean allowedPath = false;
		if (permissionList != null && permissionList.size() > 0) {
			permissionList.forEach(permission -> {
				permissionSet.add(permission.getUrl());
			});
			allowedPath = permissionSet.contains(url);
		}
		return allowedPath;

	}

}
