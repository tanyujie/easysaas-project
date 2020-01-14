package org.easymis.easysaas.gateway.security.handler;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.gateway.entitys.vo.UserVo;
import org.easymis.easysaas.gateway.security.userdetail.SecurityUserDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSON;

import reactor.core.publisher.Mono;

/**
 * 
　 * <p>Title: JwtAuthenticationSuccessHandler</p>
　 * <p>Description: 登陆成功handler</p>
　 * @author 谭宇杰
　 * @date 2020年1月15日
 */
@Component
public class JwtAuthenticationSuccessHandler implements ServerAuthenticationSuccessHandler  /*extends WebFilterChainServerAuthenticationSuccessHandler*/  {
    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        ServerWebExchange exchange = webFilterExchange.getExchange();
        ServerHttpResponse response = exchange.getResponse();
        //设置headers
        HttpHeaders httpHeaders = response.getHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        httpHeaders.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        byte[]   dataBytes={};
        UserVo userVo = new UserVo();
        SecurityUserDetails userDetails = (SecurityUserDetails) authentication.getPrincipal();
        BeanUtils.copyProperties(userDetails,userVo);
        
        RestResult success = RestResult.buildSuccess(userVo);
        try {
        	String dataBytesString=JSON.toJSONString(success);
			dataBytes=dataBytesString.getBytes("UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        DataBuffer bodyDataBuffer = response.bufferFactory().wrap(dataBytes);
        return response.writeWith(Mono.just(bodyDataBuffer));
    }
   /* @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication){
        ServerWebExchange exchange = webFilterExchange.getExchange();
        ServerHttpResponse response = exchange.getResponse();
        //设置headers
        HttpHeaders httpHeaders = response.getHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        httpHeaders.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        //设置body
        WsResponse wsResponse = WsResponse.success();
       byte[]   dataBytes={};
        ObjectMapper mapper = new ObjectMapper();
        try {
        	SecurityUserDetails user=(SecurityUserDetails)authentication.getPrincipal();
            AuthUserDetails userDetails=buildUser(user);
            byte[] authorization=(userDetails.getUsername()+":"+userDetails.getPassword()).getBytes();
            String token= Base64.getEncoder().encodeToString(authorization);
            httpHeaders.add(HttpHeaders.AUTHORIZATION, token);
            wsResponse.setResult(userDetails);
            dataBytes=mapper.writeValueAsBytes(wsResponse);
        }
        catch (Exception ex){
            ex.printStackTrace();
            JsonObject result = new JsonObject();
            result.addProperty("status", MessageCode.COMMON_FAILURE.getCode());
            result.addProperty("message", "授权异常");
            dataBytes=result.toString().getBytes();
        }
        DataBuffer bodyDataBuffer = response.bufferFactory().wrap(dataBytes);
        return response.writeWith(Mono.just(bodyDataBuffer));
    }



    private AuthUserDetails  buildUser(SecurityUserDetails user){
        AuthUserDetails userDetails=new AuthUserDetails();
        userDetails.setUsername(user.getUsername());
        userDetails.setPassword(user.getPassword().substring(user.getPassword().lastIndexOf("}")+1,user.getPassword().length()));
        return userDetails;
    }
*/

/*   
import com.alibaba.fastjson.JSONObject;
import com.sisheng.authority.common.BaseResponse;
import com.sisheng.authority.common.Constants;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import reactor.core.publisher.Mono;
 *  @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        ServerHttpResponse response = webFilterExchange.getExchange().getResponse();
        response.setStatusCode(HttpStatus.OK);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode("success");
        baseResponse.setMsg("成功");
        String body = JSONObject.toJSONString(baseResponse);
        DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(Constants.ENCODING_UTF_8_CHARSET));
        return response.writeWith(Mono.just(buffer));
    }*/




}
