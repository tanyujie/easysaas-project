package org.easymis.easysaas.member.security;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class UnauthorizedAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {
    static final String MESSAGE_TEMPLATE = "{\"status\":\"%s\",\"error\": \"Unauthorized\",\"message\": \"%s\"}";

    @Override
    public Mono<Void> commence(final ServerWebExchange exchange, final AuthenticationException authenticationException) {
        final String result = String.format(MESSAGE_TEMPLATE,
                Integer.toString(HttpStatus.UNAUTHORIZED.value()),
                authenticationException.getMessage());
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().set(HttpHeaders.CONTENT_TYPE, "application/json");
        return response.writeWith(Mono.just(response.bufferFactory().wrap(result.getBytes())));
     }
}
