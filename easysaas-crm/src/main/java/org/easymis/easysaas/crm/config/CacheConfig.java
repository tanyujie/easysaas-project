package org.easymis.easysaas.crm.config;

import java.util.concurrent.TimeUnit;

import org.easymis.easysaas.crm.entitys.dto.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * 缓存
 *
 * @author wangkai  2019/7/20
 */
@Configuration
public class CacheConfig {

    /**
     * token与用户缓存关系缓存
     * 2分钟过期时间
     */
    @Bean
    public Cache<String, Member> qrCodeLoginCache() {
        return CacheBuilder.newBuilder()
                .expireAfterWrite(2,TimeUnit.MINUTES)
                .build();
    }
}
