package org.easymis.easysaas.gateway.config;


import org.easymis.easysaas.gateway.security.access.AccessDecisionManagerImpl;
import org.easymis.easysaas.gateway.security.filer.JwtAuthenticationTokenFilter;
import org.easymis.easysaas.gateway.security.filer.JwtPasswordAuthenticationFilter;
import org.easymis.easysaas.gateway.security.handler.AnonyAuthenticationEntryPoint;
import org.easymis.easysaas.gateway.security.handler.JwtAccessDeniedHandler;
import org.easymis.easysaas.gateway.security.handler.JwtAuthenticationFailureHandler;
import org.easymis.easysaas.gateway.security.handler.JwtAuthenticationSuccessHandler;
import org.easymis.easysaas.gateway.security.handler.LogoutSuccessHandler;
import org.easymis.easysaas.gateway.security.provider.JwtAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@SuppressWarnings("deprecation")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtAuthenticationProvider jwtAuthenticationProvider;

    @Autowired
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    AccessDecisionManagerImpl accessDecisionManager;

    @Autowired
    FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/swagger-ui.html",
                "/v2/api-docs", // swagger api json
                "/swagger-resources/configuration/ui", // 用来获取支持的动作
                "/swagger-resources", // 用来获取api-docs的URI
                "/swagger-resources/configuration/security", // 安全选项
                "/swagger-resources/**",
                "/webjars/**",
                "/csrf",
                "/index/accessPermission"
        );
		// 忽略登录界面
		web.ignoring().antMatchers("/login");
		// 首页地址不拦截
		web.ignoring().antMatchers("/index.html");
		web.ignoring().antMatchers("/static/**");
		web.ignoring().antMatchers("/web/socket/**");
		web.ignoring().antMatchers("/webSocket.html");
		web.ignoring().antMatchers("/sec/sendRegisterSmsCode");

	}

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.addFilterBefore(this.getJwtPasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        httpSecurity.csrf()// 由于使用的是JWT，我们这里不需要csrf
                .disable()
                .sessionManagement()// 基于token，所以不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/user/login")// 对登录注册要允许匿名访问
                .permitAll()
                /*  .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                  .permitAll()*/
//                .antMatchers("/**")//测试时全部运行访问
//                .permitAll()
                .anyRequest()// 除上面外的所有请求全部需要鉴权认证
                .authenticated().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
                fsi.setAccessDecisionManager(accessDecisionManager);
                fsi.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
                return fsi;
            }
        })
                .and().anonymous().principal("ROLE_ANONYMOUS").and().logout().logoutUrl("/user/logout").permitAll().addLogoutHandler(new LogoutSuccessHandler());
        // 禁用缓存
        httpSecurity.headers().cacheControl();
        // 添加JWT filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(new JwtAccessDeniedHandler())
                .authenticationEntryPoint(new AnonyAuthenticationEntryPoint());
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        jwtAuthenticationProvider.setPasswordEncoder(this.getPasswordEncoder());
        auth.authenticationProvider(jwtAuthenticationProvider);

    }


    private JwtPasswordAuthenticationFilter getJwtPasswordAuthenticationFilter() throws Exception {
        JwtPasswordAuthenticationFilter jwtPasswordAuthenticationFilter = new JwtPasswordAuthenticationFilter();
        jwtPasswordAuthenticationFilter.setAuthenticationManager(authenticationManager());
        jwtPasswordAuthenticationFilter.setAuthenticationSuccessHandler(new JwtAuthenticationSuccessHandler());
        jwtPasswordAuthenticationFilter.setAuthenticationFailureHandler(new JwtAuthenticationFailureHandler());

        return jwtPasswordAuthenticationFilter;

    }

    private PasswordEncoder getPasswordEncoder() {
        return new MessageDigestPasswordEncoder("MD5");
    }


}
