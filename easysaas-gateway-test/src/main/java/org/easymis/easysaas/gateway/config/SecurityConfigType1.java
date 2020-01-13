package org.easymis.easysaas.gateway.config;

import org.easymis.easysaas.gateway.security.test1.AuthenticationFaillHandler;
import org.easymis.easysaas.gateway.security.test1.AuthenticationSuccessHandler;
import org.easymis.easysaas.gateway.security.test1.CustomHttpBasicServerAuthenticationEntryPoint;
import org.easymis.easysaas.gateway.security.test1.filter.JwtLoginFilter;
import org.easymis.easysaas.gateway.security.test1.filter.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfigType1 {


    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private AuthenticationFaillHandler authenticationFaillHandler;
    @Autowired
    private CustomHttpBasicServerAuthenticationEntryPoint customHttpBasicServerAuthenticationEntryPoint;


    //security的鉴权排除列表
    private static final String[] excludedAuthPages = {
            "/user/login",
            "/auth/logout",
            "/health",
            "/api/socket/**"
    };

    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        // 自定义登陆拦截器
        JwtLoginFilter jwtLoginFilter = new JwtLoginFilter();
        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter();
        http
                .authorizeExchange()
                .pathMatchers(excludedAuthPages).permitAll()  //无需进行权限过滤的请求路径
                .pathMatchers(HttpMethod.OPTIONS).permitAll() //option 请求默认放行
                .anyExchange().authenticated()
                .and()
                .httpBasic()
                .and()
                //.addFilterAt( jwtLoginFilter, SecurityWebFiltersOrder.LOGIN_PAGE_GENERATING) //登录拦截
                //.addFilterAt(jwtTokenFilter, SecurityWebFiltersOrder.LAST)
                .formLogin().loginPage("/user/login")
                .authenticationSuccessHandler(authenticationSuccessHandler) //认证成功
                .authenticationFailureHandler(authenticationFaillHandler) //登陆验证失败
                .and().exceptionHandling().authenticationEntryPoint(customHttpBasicServerAuthenticationEntryPoint)  //基于http的接口请求鉴权失败
                .and() .csrf().disable()//必须支持跨域
                .logout().disable();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return  NoOpPasswordEncoder.getInstance(); //默认
    }


}