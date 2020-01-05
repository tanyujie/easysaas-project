package org.easymis.easysaas.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
/**
 * 
 * @author 谭宇杰
 *
 */
@Component
public class WebSocketConfig {
	@Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
