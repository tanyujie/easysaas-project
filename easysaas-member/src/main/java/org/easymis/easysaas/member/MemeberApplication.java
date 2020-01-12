package org.easymis.easysaas.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableTransactionManagement(order = 2)
@EnableDiscoveryClient
@EnableSwagger2
@EnableWebSecurity
@MapperScan({"*.easymis.easysaas.**.mapper"})
@ComponentScan({"*.easymis.easysaas.*"})
public class MemeberApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemeberApplication.class, args);
	}
}
