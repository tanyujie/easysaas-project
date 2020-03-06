package org.easymis.easysaas.rocketmq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class LettuceConfig {
  @Value("${spring.redis.host}")
  private String host;

  @Value("${spring.redis.port}")
  private int port;

  @Value("${spring.redis.timeout}")
  private int timeout;

  @Value("${spring.redis.password}")
  private String password;

  @Value("${spring.redis.pool.maxActive}")
  private int maxActive;

  @Value("${spring.redis.pool.maxIdle}")
  private int maxIdle;

  @Value("${spring.redis.pool.minIdle}")
  private int minIdle;

  @Value("${spring.redis.pool.maxWait}")
  private int maxWaitMillis;

  @Bean
  public LettuceConnectionFactory lettucePoolFactory() {
    RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
    redisStandaloneConfiguration.setHostName(host);
    redisStandaloneConfiguration.setPort(port);
    redisStandaloneConfiguration.setPassword(password);

    LettuceClientConfiguration.LettuceClientConfigurationBuilder lettuceClientConfigurationBuilder = LettuceClientConfiguration.builder();
    LettuceConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration,
            lettuceClientConfigurationBuilder.build());
    return factory;
  }

}
