package org.easymis.easycrm.web.config;


import java.util.Arrays;
import java.util.stream.Collectors;

import org.easymis.easycrm.web.security.access.AccessDecisionManagerImpl;
import org.easymis.easycrm.web.security.filter.PcPasswordAuthenticationFilter;
import org.easymis.easycrm.web.security.handler.AnonyAuthenticationEntryPoint;
import org.easymis.easycrm.web.security.handler.LogoutSuccessHandler;
import org.easymis.easycrm.web.security.handler.PcAccessDeniedHandler;
import org.easymis.easycrm.web.security.handler.PcAuthenticationFailureHandler;
import org.easymis.easycrm.web.security.handler.PcAuthenticationSuccessHandler;
import org.easymis.easycrm.web.security.provider.PcAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    PcAuthenticationProvider pcPasswordAuthProvider;
    @Qualifier("PcPasswordUserDetailService")
    @Autowired
    UserDetailsService pcPasswordUserDetailService;
    @Autowired
    AccessDecisionManagerImpl accessDecisionManager;
    @Autowired
    FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;
    @Value("${cors.origins}")
    private String[] corsOrigins;


    @Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(

				"/webjars/**", "/sec/**", "/v2/**", "/swagger**", "/swagger-resources/**"//用来获取api-docs的URI

		);
		// 忽略登录界面
		web.ignoring().antMatchers("/login");
		// 首页地址不拦截
		web.ignoring().antMatchers("/index.html");
		web.ignoring().antMatchers("/static/**");
		web.ignoring().antMatchers("/web/socket/**");
		web.ignoring().antMatchers("/webSocket.html");

	}
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.stream(corsOrigins).collect(Collectors.toList()));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.applyPermitDefaultValues();

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(corsConfigurationSource());
        http.csrf().disable();

        http.addFilterBefore(this.getPcPasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);


        http.authorizeRequests().mvcMatchers(HttpMethod.POST, "/user/login").permitAll()
                .anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
                        fsi.setAccessDecisionManager(accessDecisionManager);
                        fsi.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
                        return fsi;
                    }
                })
                // .and().rememberMe().userDetailsService(pcPasswordUserDetailService).key("banza")
                .and().anonymous().principal("ROLE_ANONYMOUS").and()
                .logout().logoutUrl("/user/logout").permitAll().invalidateHttpSession(true).
                deleteCookies("JSESSIONID").addLogoutHandler(new LogoutSuccessHandler()).
                and().sessionManagement().maximumSessions(1);
        ;

        // http.rememberMe().key("banza").userDetailsService(pcPasswordUserDetailService).;
        //添加自定义未授权和未登录结果返回
        http.exceptionHandling().accessDeniedHandler(new PcAccessDeniedHandler()).authenticationEntryPoint(new AnonyAuthenticationEntryPoint());
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        pcPasswordAuthProvider.setPasswordEncoder(this.getPasswordEncoder());
        auth.authenticationProvider(pcPasswordAuthProvider);


    }


    public PcPasswordAuthenticationFilter getPcPasswordAuthenticationFilter() throws Exception {
        PcPasswordAuthenticationFilter pcPasswordAuthenticationFilter = new PcPasswordAuthenticationFilter();
        pcPasswordAuthenticationFilter.setAuthenticationManager(authenticationManager());
        pcPasswordAuthenticationFilter.setAuthenticationSuccessHandler(new PcAuthenticationSuccessHandler());
        pcPasswordAuthenticationFilter.setAuthenticationFailureHandler(new PcAuthenticationFailureHandler());
        pcPasswordAuthenticationFilter.setRememberMeServices(new TokenBasedRememberMeServices("easymis", pcPasswordUserDetailService));
        return pcPasswordAuthenticationFilter;

    }

    private PasswordEncoder getPasswordEncoder() {
        return new MessageDigestPasswordEncoder("MD5");
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

