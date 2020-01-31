package org.easymis.easysaas.portal.config.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.portal.utils.JwtTokenUtil;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	private static final PathMatcher pathMatcher = new AntPathMatcher();
    private static final String tokenHeader = "Authorization";

    private static final String tokenHead = "Bearer ";

	private static final Set<String> ALLOWED_PATHS = Collections
			.unmodifiableSet(new HashSet<>(Arrays.asList("/", "*.css", 
					"/assets/js/popper.min.js",
					"/assets/bootstrap-4.3.1-dist/js/bootstrap.min.js",
					"/css/login.css",
					"/css/common.css",
					"*.css",
					"/js", "/favicon.ico", "/assets/**", "/search",
					"/user/login", "/auth/logout", "/health", "/api/socket/**")));
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String url = request.getServletPath();	
		if(canIgnore(request.getRequestURI()))
			System.out.print("Ok!!!"+"-uri:"+request.getRequestURI());
		boolean allowedPath = ALLOWED_PATHS.contains(url);
		if (allowedPath) {
			log.info("url->{}过期", url);
			String authHeader = this.getTokenByRequest(request);
			if (authHeader != null && authHeader.startsWith(tokenHead)) {
				// 检查jwt令牌, 如果令牌不合法或者过期, 里面会直接抛出异常, 下面的catch部分会直接返回
				String authToken = authHeader.substring(tokenHead.length());
				String username = null;
				try {
					username = JwtTokenUtil.getUserNameFromToken(authToken);
				} catch (ExpiredJwtException e) {
					log.info("token->{}过期", authToken);
					/*		            fail.setMsg("token过期");
					out.write(JSON.toJSONString(fail));
					out.flush();
					out.close();*/
					return;
				}
			} else {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json;charset=utf-8");
				PrintWriter out = response.getWriter();
				RestResult fail = RestResult.buildFail();
	            fail.setMsg("token不能为空");
/*				out.write(JSON.toJSONString(fail));
				out.flush();
				out.close();*/

			}
		}

		filterChain.doFilter(request, response);
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
    public boolean canIgnore(String uri) {  
        boolean isExcludedPage = false;
        for (String page : ALLOWED_PATHS) {// 判断是否在过滤url之外
            if (uri.equals(page)) {
                isExcludedPage = true;
                break;
            }
        }
        return isExcludedPage;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JwtAuthenticationFilter jwtf= new JwtAuthenticationFilter();
	    if (jwtf.canIgnore("w.css")) {  
	        System.out.print("Ok!!!");
	       } 
	}

}
