package org.easymis.easycrm.common.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.WebAppRootListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class WebAppRootContext implements ServletContextInitializer {

    @Value("${websocket.bufferSize}")
    private String bufferSize;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("WebSocket最大文本长度：" + bufferSize);
        servletContext.addListener(WebAppRootListener.class);
        servletContext.setInitParameter("org.apache.tomcat.websocket.textBufferSize", bufferSize);
    }

}
