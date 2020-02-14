package org.easymis.easysaas.portal.config;

import java.util.Arrays;
import java.util.List;

import org.easymis.easysaas.portal.config.filter.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

	private static final List<String> EXCLUDE_PATH = Arrays.asList("/", "/plugin/**","/css/**", "/**/*.css", "/js/**", "/**/*.js",
			"/**/*.png", "/**/*.jpg", "/**/*.jpeg", "/**/*.gif", "/**/fonts/*", "/assets/**", "/material/**",
			"/index.html",
			"/search/**",
			"/hotSearch/**",
			"/company/*.html",
			"/company/insert/all",
			"/dishonest", 
			"/dishonest/result",
			"/human/**",
			"/dishonest/detail/**",
			"/dishonest/detail/person/*.html",
			"dishonest/detail/company/*.html","/",
			"/vipintro.html",
			"/vipbusiness.html",
			"/batch",
			"/check",
			"/map",
			"/claim/entry",
			"/indexes/**",
			"/user/login", "/error");

	public void addInterceptors(InterceptorRegistry registry) {
		// 注册自定义拦截器，添加拦截路径和排除拦截路径
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(EXCLUDE_PATH);// 拦截除登录以外的其他接口
	}
}
