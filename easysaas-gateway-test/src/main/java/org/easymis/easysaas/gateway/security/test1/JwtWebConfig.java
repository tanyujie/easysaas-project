package org.easymis.easysaas.gateway.security.test1;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.alibaba.fastjson.JSONObject;

import reactor.core.publisher.Mono;

@Configuration
public class JwtWebConfig implements WebFilter {

	@Override

	public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {

		ServerHttpRequest request = serverWebExchange.getRequest();

		if (request.getPath().value().contains("login")) {

			return webFilterChain.filter(serverWebExchange);

		}

		ServerHttpResponse response = serverWebExchange.getResponse();

		String authorization = request.getHeaders().getFirst("Authoriszation");

		if (authorization == null || !authorization.startsWith("Bearer ")) {

			return this.setErrorResponse(response, "未携带token");

		}

		String token = authorization.substring(7);

		try {

			//serverWebExchange.getAttributes().put("user", Jwt.parseJwt(token));

		} catch (Exception e) {

			return this.setErrorResponse(response, e.getMessage());

		}

		return webFilterChain.filter(serverWebExchange);

	}

	protected Mono<Void> setErrorResponse(ServerHttpResponse response, String message) {

		response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("status_code", 500);

		jsonObject.put("data", message);

		return response.writeWith(Mono.just(response.bufferFactory().wrap(jsonObject.toString().getBytes())));

	}

}
