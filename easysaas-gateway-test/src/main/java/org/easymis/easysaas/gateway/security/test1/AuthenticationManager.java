package org.easymis.easysaas.gateway.security.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.easymis.easysaas.gateway.security.check.LoginWrongChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
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
public class AuthenticationManager implements ReactiveAuthenticationManager {
    private LoginWrongChecker checker = new LoginWrongChecker();
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
	@Override
	public Mono<Authentication> authenticate(Authentication authentication) throws AuthenticationException{
		String password = (String) authentication.getCredentials();
		String username = authentication.getPrincipal() == null ? "NONE_PROVIDED" : authentication.getName();
		UserDetails userDetails;
		if(username.length()>1000) {
			//一键登录
		}else {
            try {
                checker.check(redisTemplate,username);
                //userDetails = passwordUserDetailService.loadUserByUsername(username);
            } catch (UsernameNotFoundException var6) {
               // this.logger.debug("User '" + username + "' not found");
                throw var6;
            }
		}
		String authToekn = authentication.getCredentials().toString();
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

		}
	}

}
