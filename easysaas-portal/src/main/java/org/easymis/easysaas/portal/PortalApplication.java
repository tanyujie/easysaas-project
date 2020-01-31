package org.easymis.easysaas.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableTransactionManagement(order = 2) // 设置事务执行顺序(需要在切换数据源之后，否则只走主库)
@MapperScan({"*.easymis.easysaas.portal.**.mapper"})
@EnableSwagger2
@ComponentScan({"*.easymis.easysaas.portal.*"})
public class PortalApplication {    
	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}
/*	@Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> jwtFilter() {
        final FilterRegistrationBean<JwtAuthenticationFilter> registrationBean = new FilterRegistrationBean<JwtAuthenticationFilter>();
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
        registrationBean.setFilter(filter);
        return registrationBean;
    }*/
}
