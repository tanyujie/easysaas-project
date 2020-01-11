package org.easymis.easysaas.gateway.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.util.Assert;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class UnauthorizedEntryPoint implements ServerAuthenticationEntryPoint {
	private static final String WWW_AUTHENTICATE = "WWW-Authenticate";
	private static final String DEFAULT_REALM = "Realm";
	private static String WWW_AUTHENTICATE_FORMAT = "Basic realm=\"%s\"";

	private String headerValue = createHeaderValue(DEFAULT_REALM);
	@Override
	public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
		return Mono.fromRunnable(() -> {
			ServerHttpResponse response = exchange.getResponse();
			response.setStatusCode(HttpStatus.UNAUTHORIZED);
			//response.getHeaders().set(WWW_AUTHENTICATE, this.headerValue);
		    HttpServletResponse res = (HttpServletResponse) response;
		    try {
				ServletOutputStream out=res.getOutputStream();
				res.setCharacterEncoding("utf-8");
				res.setContentType("application/json; charset=utf-8");
				PrintWriter writer = res.getWriter();
				Map<String, String> map = new HashMap<>();
				map.put("status", "success");
				writer.write(map.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		});
	}
	private static String createHeaderValue(String realm) {
		Assert.notNull(realm, "realm cannot be null");
		return String.format(WWW_AUTHENTICATE_FORMAT, realm);
	}

}
