package org.easymis.easysaas.open;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableTransactionManagement(order = 2) // 设置事务执行顺序(需要在切换数据源之后，否则只走主库)
@MapperScan({"*.easymis.easysaas.portal.**.mapper"})
@EnableSwagger2
@ComponentScan({"*.easymis.easysaas.open.*"})
@EnableCaching
public class OpenApplication {    
	public static void main(String[] args) {
		SpringApplication.run(OpenApplication.class, args);
	}
/*	@Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> jwtFilter() {
        final FilterRegistrationBean<JwtAuthenticationFilter> registrationBean = new FilterRegistrationBean<JwtAuthenticationFilter>();
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
        registrationBean.setFilter(filter);
        return registrationBean;
    }*/
}
