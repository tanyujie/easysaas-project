package org.easymis.easysaas.portal.config.filter;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LoginInterceptor implements HandlerInterceptor{
	private static final Set<String> ALLOWED_PATHS = Collections
			.unmodifiableSet(new HashSet<>(Arrays.asList("/", "/login/login", "/search",
					"/user/login", "/auth/logout", "/health", "/api/socket/**")));
	/**
	 * 进入controller层之前拦截请求
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param o
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
		System.out.println("---------------------开始进入请求地址拦截----------------------------");
        String url = request.getServletPath();	
        boolean allowedPath = ALLOWED_PATHS.contains(url);

        if (!allowedPath) {
			String token = request.getHeader("Authorization");
			if(!"".equals(token)||!token.isEmpty()) {
				try {
					//JwtUtils.getUID(token);
				}catch(Exception e) {
					log.error("token失效，当前url：" + url);
					e.printStackTrace();
					httpServletResponse.setHeader("tokenstatus", "timeout");//在响应头设置token状态  
					httpServletResponse.setCharacterEncoding("text/html;charset=utf-8");
					httpServletResponse.setContentType("text/html;charset=utf-8");
					httpServletResponse.getWriter().print("this token is time out");
					return false;
				}
			}else {
				
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

}
