package org.easymis.easysaas.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@Configuration
public class ElasticSearchGetIndexNameConfig {
    @Value("${spring.elasticsearch.use-index-name}")
    private String index_name;
    @Value("${spring.elasticsearch.company-index-name}")
    private String company_index_name;
    @Value("${spring.elasticsearch.address-index-name}")
    private String address_index_name;
}
