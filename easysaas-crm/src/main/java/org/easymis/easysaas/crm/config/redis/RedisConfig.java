package org.easymis.easysaas.crm.config.redis;

import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

/**
 * 自定义redis配置
 * @author hehui 
 * @date 2019年3月12日
 *
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
	
	

	/**
	 * 重写生成key的方法：类名+方法名+参数名
	 */
	@Bean
	@Override
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
            public Object generate(Object target, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName()).append(".").append(method.getName()).append(Arrays.toString(objects));
                return sb.toString();
            }
        };
	}

	@Bean("redisTemplate")
	public RedisTemplate<Object, Object> redisTemplate(
			RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
		template.setConnectionFactory(redisConnectionFactory);
//		Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
		GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
		template.setDefaultSerializer(serializer);
		return template;
	}
	
}
