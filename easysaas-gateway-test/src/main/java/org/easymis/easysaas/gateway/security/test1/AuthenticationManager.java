package org.easymis.easysaas.gateway.security.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

	@Override
	public Mono<Authentication> authenticate(Authentication authentication) {
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
