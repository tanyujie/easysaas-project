package org.easymis.easycrm.operation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 
* @ClassName: DefaultView
* @Description: TODO(门户首页)
* @author lenovo-t
* @date 2018年9月24日
*
 */
@Configuration
public class DefaultView implements  WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    } 
} 
