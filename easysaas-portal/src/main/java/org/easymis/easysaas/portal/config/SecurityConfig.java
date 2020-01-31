package org.easymis.easysaas.portal.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;



@SuppressWarnings("deprecation")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


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


}
