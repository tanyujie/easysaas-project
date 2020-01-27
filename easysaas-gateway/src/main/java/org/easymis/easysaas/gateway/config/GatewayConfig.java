package org.easymis.easysaas.gateway.config;

import org.springframework.context.annotation.Bean;

/*@Configuration*/
public class GatewayConfig {
	@Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

}
