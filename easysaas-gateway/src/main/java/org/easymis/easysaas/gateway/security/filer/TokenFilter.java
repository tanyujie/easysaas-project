package org.easymis.easysaas.gateway.security.filer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.easymis.easysaas.common.result.exception.CommConstants;
import org.easymis.easysaas.common.result.exception.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSONObject;

import reactor.core.publisher.Mono;

/**
 * token请求过滤 TokenFilter
 * @author wei.yong
 */
public class TokenFilter implements GlobalFilter, Ordered {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//不需要拦截的url map
	private Map<String, Object> ignoreUriMap = null;

	//不做拦截的url
	//@Value("${security.ignore.uri}")
	private String ignoreUri="/index/home,/index/getApiList,/index/getApiInfo,/user/register,/user/userAccount/password/login,/user/verifyCode/login,/user/firstLogin/updatePassword,/file/qiniu/download";

	@Override
	public int getOrder() {
		return -1;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//		init();
		ServerHttpRequest serverHttpRequest = exchange.getRequest();
		ServerHttpResponse serverHttpResponse = exchange.getResponse();
		//编码设置
		serverHttpResponse.getHeaders().set(CommConstants.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());

		String requestURI = serverHttpRequest.getURI().getPath();
		String queryString = serverHttpRequest.getURI().getQuery();
		String requestIp = serverHttpRequest.getRemoteAddress().getAddress().getHostAddress();
		logger.info("【token请求过滤】(TokenFilter-filter)-请求uri, 请求ip:{}, requestURI:{}, queryString:{}", requestIp, requestURI, queryString);

//		//如果是不需要校验token的URI资源
		if(null == MapUtils.getObject(ignoreUriMap, requestURI)) {
			HttpHeaders httpHeaders = serverHttpRequest.getHeaders();
			String token = httpHeaders.getFirst(CommConstants.TOKEN);
			logger.info("【token请求过滤】(TokenFilter-filter)-token请求过滤-请求URI, token:{}", token);
			//if(StringUtils.isBlank(token)) {
				//String respStr = this.addRetMsg(RetOpenResultEnum.TOKEN_NULL_ERROR);
				//logger.info("【token请求过滤】(TokenFilter-filter)-header的token为空, respStr:{}", respStr);
			//DataBuffer buffer = serverHttpResponse.bufferFactory().wrap(respStr.getBytes(StandardCharsets.UTF_8));
			//return serverHttpResponse.writeWith(Mono.just(buffer));
			//}
		}

		return chain.filter(exchange);
	}

	/**
	 *初始化
	 */
	public void init() {
		logger.info("【token请求过滤】(TokenFilter-init)-初始化, ignoreUriMap:{}", ignoreUriMap);
		if(ignoreUriMap == null || ignoreUriMap.isEmpty()) {
			this.getIgnoreUriMap();
		}
	}

    /**
     * 设置返回信息（编码/编码信息）
     * @param retCode
     * @param retMsg
     * @return String
     */
    public String addRetMsg(ResultEnum enums) {
		JSONObject json = new JSONObject();
    	json.put(CommConstants.RET_CODE, enums.getCode());
    	json.put(CommConstants.RET_MSG, enums.getMsg());
    	return json.toJSONString();
    }

	/**
	 * 获得不需要拦截的url
	 */
	public void getIgnoreUriMap() {
		this.ignoreUriMap = new ConcurrentHashMap<String, Object>();
		String[] excludePaths = StringUtils.split(ignoreUri, ",");
		if(excludePaths != null && excludePaths.length >0) {
			for (String igUri : excludePaths) {
				if(StringUtils.isNotBlank(igUri)) {
					ignoreUriMap.put(igUri.trim(), igUri.trim());
				}
			}
		}
	}

}