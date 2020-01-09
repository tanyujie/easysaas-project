package org.easymis.easysaas.gateway.security.handler;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.gateway.security.userdetail.SecurityUserDetails;
import org.easymis.easysaas.gateway.security.userdetail.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.alibaba.fastjson.JSON;


public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        Writer writer = httpServletResponse.getWriter();
        SecurityUserDetails userDetails = (SecurityUserDetails) authentication.getPrincipal();
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userDetails,userVo);
      //  String token = JwtTokenUtil.generateToken(userDetails.getPhoneNumber());
        RestResult success = RestResult.buildSuccess(userVo);
        writer.write(JSON.toJSONString(success));
        writer.flush();
        writer.close();
    }
}
