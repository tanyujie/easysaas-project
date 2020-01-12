package org.easymis.easysaas.member.security.filer;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymis.easysaas.common.cache.RedisPrefixConstant;
import org.easymis.easysaas.common.cache.RedisUtils;
import org.easymis.easysaas.member.security.exception.TokenAuthenticationException;
import org.easymis.easysaas.member.security.handler.JwtAuthenticationFailureHandler;
import org.easymis.easysaas.member.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Qualifier("JwtPasswordUserDetailService")
    @Autowired
    private UserDetailsService userDetailsService;

    private static final String tokenHeader = "Authorization";

    private static final String tokenHead = "Bearer ";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String authHeader = this.getTokenByRequest(request);
        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            // The part after "Bearer "
            String authToken = authHeader.substring(tokenHead.length());
            String username = null;
            try {
                username = JwtTokenUtil.getUserNameFromToken(authToken);

                //  String username = JwtTokenUtil.getUserNameFromToken(authToken);

                log.info("checking username:{}", username);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = this.userDetailsService.loadUserByUsername(username); //手机号
                    if (JwtTokenUtil.validateToken(authToken, username)) {
                        if (!JwtTokenUtil.isTokenExpired(authToken)) {
                            this.checkTokenFromCache(authToken,username);
                            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            log.info("authenticated user:{}", username);
                            SecurityContextHolder.getContext().setAuthentication(authentication);
                        } else {
                            throw new ExpiredJwtException(null, null, "");
                        }
                    }
                }

            } catch (ExpiredJwtException e) {
                log.info("token->{}过期", authToken);
                new JwtAuthenticationFailureHandler().onAuthenticationFailure(request, response, new TokenAuthenticationException("token过期,请重新登录"));  //暂时使用该handler代替
                return;
            } catch (DisabledException e) {
                new JwtAuthenticationFailureHandler().onAuthenticationFailure(request, response, e);  //暂时使用该handler代替
                return;
            }
        }
        chain.doFilter(request, response);
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
        Object value = redisTemplate.opsForValue().get(RedisUtils.joinKey(RedisPrefixConstant.token, username));
        if (Objects.nonNull(value)) {
            String token = (String) value;
            if (!Objects.equals(token, authToken)) {
                throw new ExpiredJwtException(null, null, "");
            }
        }
    }




}
