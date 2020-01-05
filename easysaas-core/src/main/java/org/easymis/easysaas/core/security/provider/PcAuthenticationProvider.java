package org.easymis.easysaas.core.security.provider;

import java.util.Collection;
import java.util.Objects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.easymis.easysaas.core.cache.RedisPrefixConstant;
import org.easymis.easysaas.core.cache.RedisUtils;
import org.easymis.easysaas.core.security.check.LoginWrongChecker;
import org.easymis.easysaas.core.security.service.PcPasswordUserDetailService;
import org.easymis.easysaas.core.security.service.UserService;
import org.easymis.easysaas.core.security.userdetail.SecurityUserDetails;
import org.easymis.easysaas.core.security.userdetail.User;
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

@Component
public class PcAuthenticationProvider implements AuthenticationProvider {

    protected final Log logger = LogFactory.getLog(this.getClass());
    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
    
    @Autowired
    PcPasswordUserDetailService passwordUserDetailService;


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
        try {
            checker.check(redisTemplate,username);
            userDetails = passwordUserDetailService.loadUserByUsername(username);
        } catch (UsernameNotFoundException var6) {
            this.logger.debug("User '" + username + "' not found");
            throw var6;
        }

        //先确认是不是手机验证码
        if (password.length() !=32) {
            String cacheCode = (String) redisTemplate.opsForValue().get(RedisUtils.joinKey(RedisPrefixConstant.USER_REG_SMS, username));
            if (!Objects.equals(cacheCode, password)) {
                checker.loginError(redisTemplate,username);
                throw new BadCredentialsException("验证码错误");
            } else {
                //第一登录，并注册账号
                if (Objects.isNull(userDetails.getUsername())) {
                    User user = userService.quickReg(username);
                    userDetails = new SecurityUserDetails().setUserNo(user.getUserNo()).setPhoneNumber(user.getPhoneNumber()).setUsername(username).setPassword(password).setId(user.getId());
                }
                //自定义
                Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
                if(Objects.isNull(authorities)){

                }
                return new UsernamePasswordAuthenticationToken(userDetails, password, authorities);
            }
        }

        if (Objects.equals(userDetails.getPassword(), password)) {
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            return new UsernamePasswordAuthenticationToken(userDetails, password, authorities);
        } else {
            checker.loginError(redisTemplate,username);
            this.logger.info("Authentication failed: 用户名或密码不正确");
            throw new BadCredentialsException("用户名或密码不正确");
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
}
