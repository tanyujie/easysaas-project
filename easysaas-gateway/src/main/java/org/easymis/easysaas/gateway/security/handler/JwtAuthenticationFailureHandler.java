package org.easymis.easysaas.gateway.security.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.gateway.security.exception.TokenAuthenticationException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.alibaba.fastjson.JSON;


public class JwtAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        RestResult fail = null;
        if (exception instanceof TokenAuthenticationException) {
            fail = RestResult.buildOAuthFail2();
            fail.setMsg(exception.getMessage());
        }else if(exception instanceof DisabledException){
            fail = RestResult.buildFail();
            fail.setMsg(exception.getMessage());
        } else {
            fail = RestResult.buildFail();
            fail.setMsg(exception.getMessage());
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(fail));
        out.flush();
        out.close();
    }
}
