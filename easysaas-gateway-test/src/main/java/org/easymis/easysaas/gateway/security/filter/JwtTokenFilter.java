package org.easymis.easysaas.gateway.security.filter;

import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

/**
  未启用
 * @Des: Token有效性验证拦截器
 */
public class JwtTokenFilter implements WebFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		System.out.print("JwtTokenFilter");
		return null;
	}}