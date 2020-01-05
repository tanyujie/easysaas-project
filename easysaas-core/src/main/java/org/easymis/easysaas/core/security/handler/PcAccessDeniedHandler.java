package org.easymis.easycrm.core.security.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymis.easycrm.core.security.RestResult;
import org.easymis.easycrm.core.security.ResultCode;
import org.easymis.easycrm.core.security.exception.NotVipException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.alibaba.fastjson.JSON;

public class PcAccessDeniedHandler implements AccessDeniedHandler {


    public static String[] preciseQuery = new String[]{"/summary/preciseQuery", "/summary/tagQuery", "/summary/addressQuery","/user/preciseQueryEntrance"};

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException{
        RestResult restResult = RestResult.buildFail(e.getMessage());
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String uri = request.getRequestURI();
        Boolean contain = containPreciseQuery(uri);
        if(contain){
            response.setStatus(HttpServletResponse.SC_OK);
            restResult = new RestResult(ResultCode.PRECISE, "", false);
        }else if(e instanceof NotVipException && !contain){
            response.setStatus(HttpServletResponse.SC_OK);
            restResult = new RestResult(ResultCode.VALUEADDEDFAIL, "查看更多内容请购买会员", false);
        }
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(restResult));
        out.flush();
        out.close();
    }


    public Boolean containPreciseQuery(String uri) {
        uri = Optional.ofNullable(uri).orElse("");
        Boolean contain = false;
        for (int i = 0; i < preciseQuery.length; i++) {
            if(uri.contains(preciseQuery[i])){
                contain =true;
            }
        }
        return contain;
    }
}
