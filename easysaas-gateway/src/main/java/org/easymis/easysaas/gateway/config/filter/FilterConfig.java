package org.easymis.easysaas.gateway.config.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class FilterConfig {
	 @Bean
	    public FilterRegistrationBean registrationBean() {
	        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());
	        filterRegistrationBean.addUrlPatterns("/*");
	        return filterRegistrationBean;
	    }
}
