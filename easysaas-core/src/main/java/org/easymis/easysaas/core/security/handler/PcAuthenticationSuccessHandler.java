package org.easymis.easycrm.core.security.handler;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymis.easycrm.core.config.SpringContextUtils;
import org.easymis.easycrm.core.security.RestResult;
import org.easymis.easycrm.core.security.service.UserService;
import org.easymis.easycrm.core.security.service.impl.UserServiceImpl;
import org.easymis.easycrm.core.security.userdetail.SecurityUserDetails;
import org.easymis.easycrm.core.security.userdetail.User;
import org.easymis.easycrm.core.security.userdetail.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;


public class PcAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        Writer writer = httpServletResponse.getWriter();
        SecurityUserDetails userDetails = (SecurityUserDetails) authentication.getPrincipal();
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userDetails,userVo);
        
        UserService userService = (UserService) SpringContextUtils.getApplicationContext().getBean(UserServiceImpl.class);
        User user=userService.findByUserno(userDetails.getUserNo());
		String token = getToken(user);
		userVo.setToken(token);        
    
		Cookie cookie = new Cookie("token", token);
		cookie.setPath("/");
		httpServletResponse.addCookie(cookie);        
        
        
        RestResult success = RestResult.buildSuccess(userVo);
        writer.write(JSON.toJSONString(success));
        writer.flush();
        writer.close();
    }
	public String getToken(User user) {
		Date start = new Date();
		long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
		Date end = new Date(currentTime);
		String token = "";
		
		token = JWT.create().withAudience(user.getUserNo()).withIssuedAt(start).withExpiresAt(end)
				.sign(Algorithm.HMAC256(user.getPassword()));
		return token;
	}
}
