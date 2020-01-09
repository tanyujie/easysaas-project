package org.easymis.easysaas.gateway.security.provider;


import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.easymis.easysaas.common.cache.RedisPrefixConstant;
import org.easymis.easysaas.common.cache.RedisUtils;
import org.easymis.easysaas.common.sms.AliyunGetMobile;
import org.easymis.easysaas.gateway.security.check.LoginWrongChecker;
import org.easymis.easysaas.gateway.security.service.UserService;
import org.easymis.easysaas.gateway.security.service.impl.JwtPasswordUserDetailService;
import org.easymis.easysaas.gateway.security.userdetail.SecurityUserDetails;
import org.easymis.easysaas.gateway.security.userdetail.User;
import org.easymis.easysaas.gateway.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.aliyuncs.dypnsapi.model.v20170525.GetMobileResponse;


@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    protected final Log logger = LogFactory.getLog(this.getClass());
    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Autowired
    JwtPasswordUserDetailService passwordUserDetailService;


    private PasswordEncoder passwordEncoder;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    UserService userService;

    private LoginWrongChecker checker = new LoginWrongChecker();


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String password = (String) authentication.getCredentials();
        String username = authentication.getPrincipal() == null ? "NONE_PROVIDED" : authentication.getName();
        UserDetails userDetails;
        if(username.length()>1000) {
            //一键登录
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
           // System.out.println(request.getParameter("oneClickLogin"));
            GetMobileResponse response= AliyunGetMobile.get(username);
            if(!response.getCode().equals("OK")) {
            	throw new UsernameNotFoundException("手机号码验证失败");
            }else {
                username=response.getGetMobileResultDTO().getMobile();            	
            }
            try {
                checker.check(redisTemplate,username);
                userDetails = passwordUserDetailService.loadUserByUsername(username);
            } catch (UsernameNotFoundException var6) {
                this.logger.debug("User '" + username + "' not found");
                throw var6;
            }

            if (Objects.isNull(userDetails.getUsername())) {
                User user = userService.quickReg(username);
                userDetails = new SecurityUserDetails().setUserNo(user.getUserNo()).setPhoneNumber(user.getPhoneNumber()).setUsername(username).setPassword(password).setId(user.getId());
            }
            checker.removeWarningRecord(redisTemplate,username);
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            this.writeNewTokenToCache(userDetails);
            return new UsernamePasswordAuthenticationToken(userDetails, password, authorities);
        
            
        }else {
            try {
                checker.check(redisTemplate,username);
                userDetails = passwordUserDetailService.loadUserByUsername(username);
            } catch (UsernameNotFoundException var6) {
                this.logger.debug("User '" + username + "' not found");
                throw var6;
            }

            //先确认是不是手机验证码
            if (password.length()!=32) {
                String cacheCode = (String) redisTemplate.opsForValue().get(RedisUtils.joinKey(RedisPrefixConstant.USER_LOGIN_SMS, username));
                if (!Objects.equals(cacheCode, password)) {
                    checker.loginError(redisTemplate,username);
                    throw new BadCredentialsException("验证码错误");
                } else {
                    if (Objects.isNull(userDetails.getUsername())) {
                        User user = userService.quickReg(username);
                        userDetails = new SecurityUserDetails().setUserNo(user.getUserNo()).setPhoneNumber(user.getPhoneNumber()).setUsername(username).setPassword(password).setId(user.getId());
                    }
                    checker.removeWarningRecord(redisTemplate,username);
                    Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
                    this.writeNewTokenToCache(userDetails);
                    return new UsernamePasswordAuthenticationToken(userDetails, password, authorities);
                }
            }

            if (Objects.equals(userDetails.getPassword(), password)) {
                checker.removeWarningRecord(redisTemplate,username);
                Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
                this.writeNewTokenToCache(userDetails);
                return new UsernamePasswordAuthenticationToken(userDetails, password, authorities);
            } else {
                checker.loginError(redisTemplate,username);
                this.logger.info("Authentication failed: 用户名或密码不正确");
                throw new BadCredentialsException("用户名或密码不正确");
            }        	
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }


    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public void writeNewTokenToCache(UserDetails userDetails) {
        SecurityUserDetails securityUserDetails = (SecurityUserDetails) userDetails;
        String jwt = JwtTokenUtil.generateToken(securityUserDetails.getPhoneNumber());
        securityUserDetails.setToken(jwt);
        redisTemplate.opsForValue()
                .set(RedisUtils.joinKey(RedisPrefixConstant.token, securityUserDetails.getPhoneNumber()),jwt, JwtTokenUtil.getExpiration()-1, TimeUnit.SECONDS);
    }
}
