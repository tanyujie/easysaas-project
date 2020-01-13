package org.easymis.easysaas.gateway.security;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.easymis.easysaas.gateway.config.RequestHolder;
import org.easymis.easysaas.gateway.entitys.vo.Role;
import org.easymis.easysaas.gateway.security.handler.JwtAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Component
@Slf4j
public class AuthenticationManager implements ReactiveAuthenticationManager {

	@Autowired
	private JWTUtil jwtUtil;
	
	@Override
	@SuppressWarnings("unchecked")
	public Mono<Authentication> authenticate(Authentication authentication)   {
		String authToken = authentication.getCredentials().toString();
		
		String username = null;
		if(authToken!=null) {
			try {
				username = jwtUtil.getUsernameFromToken(authToken);
			}catch (ExpiredJwtException e) {
	            log.info("token->{}过期", authToken);
	            	throw new UnsupportedOperationException("token过期,请重新登录");

			} catch (DisabledException e) {
				log.info("token->{}暂停使用", authToken);
				throw new UnsupportedOperationException("token过期,请重新登录"); //暂时使用该handler代替
	           // return;
	        }
		}


		if (username != null && jwtUtil.validateToken(authToken)) {
			//从数据库读取角色
			Claims claims = jwtUtil.getAllClaimsFromToken(authToken);
			List<String> rolesMap = claims.get("role", List.class);
			List<Role> roles = new ArrayList<>();
			//bug
			for (String rolemap : rolesMap) {
				roles.add(Role.valueOf(rolemap));
			}
			//bug
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
				username,
				null,
				roles.stream().map(authority -> new SimpleGrantedAuthority(authority.name())).collect(Collectors.toList())
			);
			return Mono.just(auth);
		} else {
			return Mono.empty();
		}
	}
}
