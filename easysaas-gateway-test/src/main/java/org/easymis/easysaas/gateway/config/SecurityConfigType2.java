package org.easymis.easysaas.gateway.config;

import org.easymis.easysaas.gateway.security.AuthenticationAccessDeniedHandler;
import org.easymis.easysaas.gateway.security.AuthenticationManager;
import org.easymis.easysaas.gateway.security.JwtAuthenticationWebFilter;
import org.easymis.easysaas.gateway.security.SecurityContextRepository;
import org.easymis.easysaas.gateway.security.UnauthorizedAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 *
启用webflux登陆权限校验
@EnableWebFluxSecurity
 启用@PreAuthorize注解配置，如果不加这个注解的话，即使方法中加了@PreAuthorize也不会生效

 */
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfigType2 {
    //security的鉴权排除列表
    private static final String[] AUTH_WHITELIST = {
    		"/login", 
    		"/actuator/**",
    		"/api/demo",
            "/auth/login",
            "/auth/logout",
            "/health",
            "/swagger-ui.html",
            "/v2/api-docs", // swagger api json
            "/swagger-resources/configuration/ui", // 用来获取支持的动作
            "/swagger-resources", // 用来获取api-docs的URI
            "/swagger-resources/configuration/security", // 安全选项
            "/swagger-resources/**",
            "/webjars/**",
            "/csrf",
            "/api/socket/**"
    };
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private SecurityContextRepository securityContextRepository;
	
	
	@Bean
	public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http,
			final JwtAuthenticationWebFilter authenticationWebFilter,
            final UnauthorizedAuthenticationEntryPoint entryPoint,
            final AuthenticationAccessDeniedHandler accessDeniedHandler) throws Exception {
		//管理系统启用登录
		return http
                .exceptionHandling()
                .authenticationEntryPoint(entryPoint)
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                .addFilterAt(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION)
				.csrf().disable()
				.formLogin().disable()
				.httpBasic().disable()
				.authenticationManager(authenticationManager)
				.securityContextRepository(securityContextRepository)
				.authorizeExchange()
				.pathMatchers(HttpMethod.OPTIONS).permitAll()
				.pathMatchers(AUTH_WHITELIST).permitAll()
				.anyExchange().authenticated()
				.and().build();
		
/*		return http
				.exceptionHandling()
				.authenticationEntryPoint((swe, e) -> {
					return Mono.fromRunnable(() -> {
						swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
					});
				}).accessDeniedHandler((swe, e) -> {
					return Mono.fromRunnable(() -> {
						swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
					});
				}).and()
				.csrf().disable()
				.formLogin().disable()
				.httpBasic().disable()
				.authenticationManager(authenticationManager)
				.securityContextRepository(securityContextRepository)
				.authorizeExchange()
				.pathMatchers(HttpMethod.OPTIONS).permitAll()
				.pathMatchers(AUTH_WHITELIST).permitAll()
				.anyExchange().authenticated()
				.and().build();*/
	}


}
