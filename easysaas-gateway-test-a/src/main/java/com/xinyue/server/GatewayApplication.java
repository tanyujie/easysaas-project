package com.xinyue.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@EnableDiscoveryClient*/
public class XinyueServerA {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(XinyueServerA.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.run(args);
    }
}
