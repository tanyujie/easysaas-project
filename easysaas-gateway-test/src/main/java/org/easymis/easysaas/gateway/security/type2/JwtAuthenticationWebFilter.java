package org.easymis.easysaas.gateway.security.type2;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.stereotype.Component;

/*@Component*/
public class JwtAuthenticationWebFilter extends AuthenticationWebFilter {

	public JwtAuthenticationWebFilter(ReactiveAuthenticationManager authenticationManager) {		
		super(authenticationManager);
		System.out.println("JwtAuthenticationWebFilter");
		// TODO Auto-generated constructor stub
	}
}