package org.easymis.easysaas.gateway.security;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.easymis.easysaas.common.cache.RedisPrefixConstant;
import org.easymis.easysaas.common.cache.RedisUtils;
import org.easymis.easysaas.common.sms.AliyunGetMobile;
import org.easymis.easysaas.gateway.entitys.mybatis.dto.Member;
import org.easymis.easysaas.gateway.security.check.LoginWrongChecker;
import org.easymis.easysaas.gateway.security.service.JwtPasswordUserDetailService;
import org.easymis.easysaas.gateway.security.userdetail.SecurityUserDetails;
import org.easymis.easysaas.gateway.security.utils.JwtTokenUtil;
import org.easymis.easysaas.gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.aliyuncs.dypnsapi.model.v20170525.GetMobileResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
/**
 * 
　 * <p>Title: AuthenticationManager</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月14日
AuthenticationManager 负责校验 Authentication 对象。在 AuthenticationManager 的 authenticate 函数中，开发人员实现对 Authentication 的校验逻辑。
 */
@Component
@Slf4j
public class JwtReactiveAuthenticationManager implements ReactiveAuthenticationManager {
    @Autowired
    JwtPasswordUserDetailService passwordUserDetailService;
    private LoginWrongChecker checker = new LoginWrongChecker();
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    UserService userService;
/*	@Autowired
	private JwtTokenUtil jwtTokenUtil;*/
	@Override
	public Mono<Authentication> authenticate(Authentication authentication) throws AuthenticationException{
		String password = (String) authentication.getCredentials();
		String username = authentication.getPrincipal() == null ? "NONE_PROVIDED" : authentication.getName();
		UserDetails userDetail;
		if(username.length()>1000) {
			//一键登录
            GetMobileResponse response= AliyunGetMobile.get(username);
            if(!response.getCode().equals("OK")) {
            	throw new UsernameNotFoundException("手机号码验证失败");
            }else {
                username=response.getGetMobileResultDTO().getMobile();            	
            }
            try {
                checker.check(redisTemplate,username);
                userDetail = passwordUserDetailService.findByUsername(username).block();
            } catch (UsernameNotFoundException var6) {
                log.debug("User '" + username + "' not found");
                throw var6;
            }
            if (Objects.isNull(userDetail.getUsername())) {
            	Member member = userService.saveQuickRegister(username);
            	userDetail = new SecurityUserDetails().setUserNo(member.getUserNo()).setPhoneNumber(member.getPhoneNumber()).setUsername(username).setPassword(password).setId(member.getId());
            }
            checker.removeWarningRecord(redisTemplate,username);
            Collection<? extends GrantedAuthority> authorities = userDetail.getAuthorities();
            this.writeNewTokenToCache(userDetail);
			return Mono.just(new UsernamePasswordAuthenticationToken(userDetail, password, authorities));
		}else {
            try {
                checker.check(redisTemplate,username);
                userDetail = passwordUserDetailService.findByUsername(username).block();
            } catch (UsernameNotFoundException var6) {
               // this.logger.debug("User '" + username + "' not found");
                throw var6;
            }
            
            //先确认是不是手机验证码
            if (password.length()!=60) {
                String cacheCode = (String) redisTemplate.opsForValue().get(RedisUtils.joinKey(RedisPrefixConstant.USER_LOGIN_SMS, username));
                if (!Objects.equals(cacheCode, password)) {
                    checker.loginError(redisTemplate,username);
                    throw new BadCredentialsException("验证码错误");
                } else {
                    if (Objects.isNull(userDetail.getUsername())) {
                        Member member = userService.saveQuickRegister(username);
                        userDetail = new SecurityUserDetails().setUserNo(member.getUserNo()).setPhoneNumber(member.getPhoneNumber()).setUsername(username).setPassword(password).setId(member.getId());
                    }
                    checker.removeWarningRecord(redisTemplate,username);
                    Collection<? extends GrantedAuthority> authorities = userDetail.getAuthorities();
                    this.writeNewTokenToCache(userDetail);
                    return Mono.just(new UsernamePasswordAuthenticationToken(userDetail, password, authorities));
                }
            }
            if (Objects.equals(userDetail.getPassword(), password)) {
                checker.removeWarningRecord(redisTemplate,username);
                Collection<? extends GrantedAuthority> authorities = userDetail.getAuthorities();
                this.writeNewTokenToCache(userDetail);
                Authentication auth=new UsernamePasswordAuthenticationToken(userDetail, password, authorities);
                return Mono.just(auth);
            } else {
                checker.loginError(redisTemplate,username);
                log.info("Authentication failed: 用户名或密码不正确");
                throw new BadCredentialsException("用户名或密码不正确");
            }  
		}
		/*		String authToekn = authentication.getCredentials().toString();
		String name=authentication.getName();

		try {
			System.out.println(authToekn);
			Claims claims = null;//Jwt.parseJwt(authToekn);

			// todo 此处应该列出token中携带的角色表。

			List<String> roles = new ArrayList();

			roles.add("user");

			Authentication authentication1 = new UsernamePasswordAuthenticationToken(

					claims.getId(),

					null,

					roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList())

			);

			return Mono.just(authentication1);

		} catch (Exception e) {

			throw new BadCredentialsException(e.getMessage());

		}*/
	}
    public void writeNewTokenToCache(UserDetails userDetail) {
        SecurityUserDetails securityUserDetails = (SecurityUserDetails) userDetail;
        String jwt =JwtTokenUtil.generateToken(securityUserDetails.getPhoneNumber());
        securityUserDetails.setToken(jwt);
        redisTemplate.opsForValue()
                .set(RedisUtils.joinKey(RedisPrefixConstant.token, securityUserDetails.getPhoneNumber()),jwt, JwtTokenUtil.getExpiration()-1, TimeUnit.SECONDS);
    }

}
