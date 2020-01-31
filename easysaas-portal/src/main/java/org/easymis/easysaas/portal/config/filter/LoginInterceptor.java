package org.easymis.easysaas.portal.config.filter;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.easymis.easysaas.common.cache.RedisPrefixConstant;
import org.easymis.easysaas.common.cache.RedisUtils;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.portal.config.SpringBootBeanUtil;
import org.easymis.easysaas.portal.utils.JwtTokenUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LoginInterceptor implements HandlerInterceptor{
	private static final Set<String> ALLOWED_PATHS = Collections
			.unmodifiableSet(new HashSet<>(Arrays.asList("/", "/login/login", "/search",
					"/user/login", "/auth/logout", "/health", "/api/socket/**")));
    private static final String tokenHeader = "Authorization";

    private static final String tokenHead = "Bearer ";
	/**
	 * 进入controller层之前拦截请求
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param o
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		System.out.println("---------------------开始进入请求地址拦截----------------------------");
        String url = request.getServletPath();	
        boolean allowedPath = ALLOWED_PATHS.contains(url);

        if (!allowedPath) {
			String token = request.getHeader("Authorization");

			if(StringUtils.isNotEmpty(token)) {
				try {
					String authHeader = this.getTokenByRequest(request);
					if (authHeader != null && authHeader.startsWith(tokenHead)) {
						String authToken = authHeader.substring(tokenHead.length());
						String memberId = JwtTokenUtil.getUserNameFromToken(authToken);
						
						if (JwtTokenUtil.validateToken(authToken, memberId)) {
							if (!JwtTokenUtil.isTokenExpired(authToken)) {
								checkTokenFromCache(authToken, memberId);
								  //设置 identityId 用户身份ID
						        request.setAttribute("memberId", memberId);
								// 检查角色权限
								log.info("memberId:{}",memberId);
							}else {
								response.setCharacterEncoding("UTF-8");
								response.setContentType("application/json;charset=utf-8");
								PrintWriter out = response.getWriter();
								RestResult fail = RestResult.buildFail();
					            fail.setMsg("token失效，请重新登录");
								out.write(JSON.toJSONString(fail));
								out.flush();
								out.close();
								return false;
							}

							
						}else {
							response.setCharacterEncoding("UTF-8");
							response.setContentType("application/json;charset=utf-8");
							PrintWriter out = response.getWriter();
							RestResult fail = RestResult.buildFail();
				            fail.setMsg("token无效");
							out.write(JSON.toJSONString(fail));
							out.flush();
							out.close();
							return false;
						}
					}

					//JwtUtils.getUID(token);
				}catch(Exception e) {
					log.error("token失效，当前url：" + url);
					e.printStackTrace();
					response.setHeader("tokenstatus", "timeout");//在响应头设置token状态  
					response.setCharacterEncoding("text/html;charset=utf-8");
					response.setContentType("text/html;charset=utf-8");
					response.getWriter().print("this token is time out");
					return false;
				}
			}else {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json;charset=utf-8");
				PrintWriter out = response.getWriter();
				RestResult fail = RestResult.buildFail();
	            fail.setMsg("token不能为空");
				out.write(JSON.toJSONString(fail));
				out.flush();
				out.close();
				return false;
			}
        }
		return true;
	}
 
	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
		System.out.println("--------------处理请求完成后视图渲染之前的处理操作---------------");
	}
 
	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
		System.out.println("---------------视图渲染之后的操作-------------------------");
	}
    public String getTokenByRequest(HttpServletRequest request) {
        String authHeader = request.getParameter("abc");
        if (Objects.isNull(authHeader)) {
            authHeader = request.getHeader(tokenHeader);
            return authHeader;
        } else {
            return tokenHead + authHeader;
        }
    }
    public void checkTokenFromCache(String authToken, String username) {
        
        RedisTemplate<String, Object> redisTemplate= (RedisTemplate) SpringBootBeanUtil.getBean("redisTemplate");
        Object value = redisTemplate.opsForValue().get(RedisUtils.joinKey(RedisPrefixConstant.token, username));
        if (Objects.nonNull(value)) {
            String token = (String) value;
            if (!Objects.equals(token, authToken)) {
                throw new ExpiredJwtException(null, null, "tonken已过期，请重新登录！");
            }
        }
    }
}
