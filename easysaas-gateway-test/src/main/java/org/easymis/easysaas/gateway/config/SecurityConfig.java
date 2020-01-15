package org.easymis.easysaas.gateway.config;

import org.easymis.easysaas.gateway.security.JwtReactiveAuthenticationManager;
import org.easymis.easysaas.gateway.security.UnauthorizedAuthenticationEntryPoint;
import org.easymis.easysaas.gateway.security.filter.JwtAuthorizationFilter;
import org.easymis.easysaas.gateway.security.handler.AuthenticationAccessDeniedHandler;
import org.easymis.easysaas.gateway.security.handler.JwtAuthenticationFaillHandler;
import org.easymis.easysaas.gateway.security.handler.JwtAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private JwtAuthenticationFaillHandler authenticationFaillHandler;
    /**
     * 访问权限认证异常处理
     */
    @Autowired
    private UnauthorizedAuthenticationEntryPoint customHttpBasicServerAuthenticationEntryPoint;
    /**
     * 自定义访问无权限接口时403响应内容
     */
    @Autowired
    private AuthenticationAccessDeniedHandler urlAccessDeniedHandler;
    @Autowired 
    private JwtReactiveAuthenticationManager authenticationManager;
/*    @Autowired 
    private SecurityContextRepository securityContext;*/

    //security的鉴权排除列表
    private static final String[] excludedAuthPages = {
            "/user/login",
            "/auth/logout",
            "/health",
            "/api/socket/**"
    };

    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        // 禁用CSRF 开启跨域,必须支持跨域
        http.csrf().disable().cors();
        // 防止iframe 造成跨域
        http.headers().frameOptions().disable();
        // 自定义登陆拦截器
        http.addFilterAt(new JwtAuthorizationFilter(), SecurityWebFiltersOrder.AUTHORIZATION);
        // 未登录认证异常，用来解决匿名用户访问无权限资源时的异常,基于http的接口请求鉴权失败
        http.exceptionHandling().authenticationEntryPoint(customHttpBasicServerAuthenticationEntryPoint);   
        // 登录过后访问无权限的接口时自定义403响应内容
        http.exceptionHandling().accessDeniedHandler(urlAccessDeniedHandler);

        
        http
        		.formLogin().loginPage("/user/login")//登录页面访问路径
                .authenticationSuccessHandler(authenticationSuccessHandler) //认证成功
                .authenticationFailureHandler(authenticationFaillHandler) //登陆验证失败
                .and()
                .httpBasic().disable()
                .authenticationManager(authenticationManager)
                //.securityContextRepository(securityContext)
                .authorizeExchange()
                .pathMatchers(HttpMethod.OPTIONS).permitAll()//option 请求默认放行
                .pathMatchers("/user/login").permitAll()
                .pathMatchers(excludedAuthPages).permitAll()  //无需进行权限过滤的请求路径
                .anyExchange().authenticated()
                .and()
                .logout().disable();

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	public static void main(String[] args) {
		    Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder("1");
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	 
	        String pbk1 = pbkdf2PasswordEncoder.encode("123456");
	        pbkdf2PasswordEncoder.upgradeEncoding("2");
	        String pbk2 = pbkdf2PasswordEncoder.encode("123456");
	 
	        String bcr1 = bCryptPasswordEncoder.encode("123456");
	        String bcr2 = bCryptPasswordEncoder.encode("123456");
	 
	        System.out.println("pbk1: " + pbk1.length());
	        System.out.println("pbk2: " + pbk2.length());
	        System.out.println("pbk1 password:" + pbkdf2PasswordEncoder.matches("123456",pbk1));
	        System.out.println("pbk2 password:" + pbkdf2PasswordEncoder.matches("123456",pbk2));
	 
	        System.out.println("---------------------");
	 
	        System.out.println("bcr1: " + bcr1);
	        System.out.println("bcr2: " + bcr2.length());
	        System.out.println("bcr1 password:" + bCryptPasswordEncoder.matches("123456",bcr1));
	        System.out.println("bcr2 password:" + bCryptPasswordEncoder.matches("123456",bcr2));
	}
}