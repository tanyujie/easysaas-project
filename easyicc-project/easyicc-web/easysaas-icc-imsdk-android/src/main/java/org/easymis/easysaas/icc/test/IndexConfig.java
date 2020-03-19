package org.easymis.easysaas.icc.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class IndexConfig implements WebMvcConfigurer {
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController( "/" ).setViewName( "forward:/index-config.html" );
	        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
	        WebMvcConfigurer.super.addViewControllers(registry);
	    }	
}
