package org.easymis.easysaas.rocketmq.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfiguration {
  @Autowired
  private LettuceConnectionFactory lettuceConnectionFactory; 
  
  @Bean
  public RedisTemplate<String, Object> redisTemplate() {
      RedisTemplate<String, Object> template = new RedisTemplate<>();
      template.setKeySerializer(new StringRedisSerializer());
      template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
      template.setConnectionFactory(lettuceConnectionFactory);
      return template;
  }
}
