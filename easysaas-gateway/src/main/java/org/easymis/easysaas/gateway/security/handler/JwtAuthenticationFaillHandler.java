package org.easymis.easysaas.gateway.security.handler;

import org.easymis.easysaas.gateway.entitys.vo.MessageCode;
import org.easymis.easysaas.gateway.entitys.vo.WsResponse;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;
/**
 * 
　 * <p>Title: JwtAuthenticationFaillHandler</p>
　 * <p>Description: 登陆失败handler</p>
　 * @author 谭宇杰
　 * @date 2020年1月15日
 */
@Component
public class JwtAuthenticationFaillHandler  implements ServerAuthenticationFailureHandler {

    @Override
    public Mono<Void> onAuthenticationFailure(WebFilterExchange webFilterExchange, AuthenticationException e) {
        ServerWebExchange exchange = webFilterExchange.getExchange();
        ServerHttpResponse response = exchange.getResponse();
        //设置headers
        HttpHeaders httpHeaders = response.getHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        httpHeaders.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        //设置body
        WsResponse<String> wsResponse = WsResponse.failure(MessageCode.COMMON_AUTHORIZED_FAILURE);
        byte[]   dataBytes={};
        try {
            ObjectMapper mapper = new ObjectMapper();
            dataBytes=mapper.writeValueAsBytes(wsResponse);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        DataBuffer bodyDataBuffer = response.bufferFactory().wrap(dataBytes);
        return response.writeWith(Mono.just(bodyDataBuffer));
    }
    
/*    private Mono<Void> writeErrorMessage(ServerHttpResponse response, ErrorEnum errorEnum) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(errorEnum.getCode());
        baseResponse.setMsg(errorEnum.getMessage());
        String result = JSONObject.toJSONString(baseResponse);
        DataBuffer buffer = response.bufferFactory().wrap(result.getBytes(Constants.ENCODING_UTF_8_CHARSET));
        return response.writeWith(Mono.just(buffer));
    }*/

}