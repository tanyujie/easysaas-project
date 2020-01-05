package org.easymis.easycrm.operation.security.handler;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymis.easycrm.operation.security.RestResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.alibaba.fastjson.JSON;

public class LogoutSuccessHandler implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {

        try {
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write(JSON.toJSONString(RestResult.buildSuccess()));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
