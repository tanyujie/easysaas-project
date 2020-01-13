package org.easymis.easysaas.gateway.security.test1;

import org.easymis.easysaas.gateway.entitys.vo.MessageCode;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.google.gson.JsonObject;

import reactor.core.publisher.Mono;
@Component
public class CustomAccessDeineHandler implements ServerAccessDeniedHandler {

	@Override
	public Mono<Void> handle(ServerWebExchange serverWebExchange, AccessDeniedException denied) {

		ServerHttpResponse response = serverWebExchange.getResponse();
		// 设置headers
		HttpHeaders httpHeaders = response.getHeaders();
		httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
		httpHeaders.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
		// 设置body
		byte[] dataBytes = {};

		denied.printStackTrace();
		JsonObject result = new JsonObject();
		result.addProperty("status", MessageCode.COMMON_FAILURE.getCode());
		result.addProperty("message", "授权异常");
		dataBytes = result.toString().getBytes();

		DataBuffer bodyDataBuffer = response.bufferFactory().wrap(dataBytes);
		return response.writeWith(Mono.just(bodyDataBuffer));
	}

}