package org.easymis.easysaas.gateway.security.test1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.easymis.easysaas.common.cache.RedisPrefixConstant;
import org.easymis.easysaas.common.cache.RedisUtils;
import org.easymis.easysaas.gateway.config.SpringBootBeanUtil;
import org.easymis.easysaas.gateway.security.service.JwtPasswordUserDetailService;
import org.easymis.easysaas.gateway.security.utils.JwtTokenUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.alibaba.fastjson.JSONObject;

import io.jsonwebtoken.ExpiredJwtException;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class JwtWebConfig implements WebFilter {
    private static final String tokenHeader = "Authorization";
    private static final String tokenHead = "Bearer ";

	private static final Set<String> ALLOWED_PATHS = Collections
			.unmodifiableSet(new HashSet<>(Arrays.asList("/user/login", "/auth/logout", "/health", "/api/socket/**")));
	@Override
	public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) throws ExpiredJwtException{
		ServerHttpRequest request = serverWebExchange.getRequest();
		ServerHttpResponse response = serverWebExchange.getResponse();
		boolean allowedPath = ALLOWED_PATHS.contains(request.getPath().value());
		if (allowedPath) {
			return webFilterChain.filter(serverWebExchange);
		}else {String authHeader = request.getHeaders().getFirst(tokenHeader);		
		if (StringUtils.isNotEmpty(authHeader) && authHeader.startsWith(tokenHead)) {
			 String authToken = authHeader.substring(tokenHead.length());
			 String username = null;
			try {
					
				JwtPasswordUserDetailService userDetailsService= (JwtPasswordUserDetailService) SpringBootBeanUtil.getBean("JwtPasswordUserDetailService");
				 
	                username = JwtTokenUtil.getUserNameFromToken(authToken);

	                log.info("checking username:{}", username);
	                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	                    UserDetails userDetails = userDetailsService.findByUsername(username).block(); //手机号
	                    if (JwtTokenUtil.validateToken(authToken, username)) {
	                        if (!JwtTokenUtil.isTokenExpired(authToken)) {
	                            this.checkTokenFromCache(authToken,username);
	                            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                            //authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                            log.info("authenticated user:{}", username);
	                            SecurityContextHolder.getContext().setAuthentication(authentication);
	                            serverWebExchange.getAttributes().put("user", username);
	                        } else {
	                            throw new ExpiredJwtException(null, null, "");
	                        }
	                    }
	                }

	            } catch (ExpiredJwtException e) {
	                log.info("token->{}过期", authToken);
					return this.setErrorResponse(response, e.getMessage());
	                //new JwtAuthenticationFailureHandler().onAuthenticationFailure(request, response, new TokenAuthenticationException("token过期,请重新登录"));  //暂时使用该handler代替
	            	//return this.setErrorResponse(response, e.getMessage());
	            } catch (DisabledException e) {
	               // new JwtAuthenticationFailureHandler().onAuthenticationFailure(request, response, e);  //暂时使用该handler代替
	            	return this.setErrorResponse(response, e.getMessage());
	            }
	        }else {
	        	return this.setErrorResponse(response, "token为空");
	        }			
		}
		return webFilterChain.filter(serverWebExchange);
		}

	protected Mono<Void> setErrorResponse(ServerHttpResponse response, String message) {

		response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("status_code", 500);

		jsonObject.put("data", message);

		return response.writeWith(Mono.just(response.bufferFactory().wrap(jsonObject.toString().getBytes())));

	}
    public void checkTokenFromCache(String authToken, String username) {
        
        RedisTemplate<String, Object> redisTemplate= (RedisTemplate) SpringBootBeanUtil.getBean("RedisTemplate");
        Object value = redisTemplate.opsForValue().get(RedisUtils.joinKey(RedisPrefixConstant.token, username));
        if (Objects.nonNull(value)) {
            String token = (String) value;
            if (!Objects.equals(token, authToken)) {
                throw new ExpiredJwtException(null, null, "tonken已过期");
            }
        }
    }

}
