package org.easymis.easysaas.member.security.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.common.result.ResultCode;
import org.easymis.easysaas.member.security.exception.NotVipException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.alibaba.fastjson.JSON;

public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        RestResult restResult = RestResult.buildSc_forbidden(e.getMessage());
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        if (e instanceof NotVipException) {
            response.setStatus(HttpServletResponse.SC_OK);
            restResult = new RestResult(ResultCode.VALUEADDEDFAIL, "查看更多内容请购买会员", false);
        }

        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(restResult));
        out.flush();
        out.close();
    }
}
