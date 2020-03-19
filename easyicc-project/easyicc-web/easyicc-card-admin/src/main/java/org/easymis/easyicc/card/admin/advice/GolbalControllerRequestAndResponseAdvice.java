package org.easymis.easyicc.card.admin.advice;

import java.io.Serializable;
import java.net.URLDecoder;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;


@Aspect
@Component//定义一个切面
public class GolbalControllerRequestAndResponseAdvice {
	private static final Logger logger = LoggerFactory.getLogger(GolbalControllerRequestAndResponseAdvice.class);
	private static final String UTF_8 = "utf-8";
	public final String string = "execution(*  *..*.*.controller..*.*(..))";

	// 定义切点Pointcut
	@Pointcut(string)
	public void excudeService() {
	}

	//执行切点 之前
	@Before("excudeService()")
	public void exBefore(JoinPoint pjp) {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
	}

	// 通知（环绕）
	@Around("excudeService()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		Object[] args = pjp.getArgs();
		String params = "";
		// result的值就是被拦截方法的返回值
		try {
			//long startTime = (long) request.getAttribute("startTime");
			//获取请求参数集合并进行遍历拼接
			if (args.length > 0) {
				if ("POST".equals(method)) {
					StringBuilder postparams = new StringBuilder();
					for (int i = 0; i < args.length; i++) {
						if (args[i] == null) {
							postparams.append("null");
						} else if (args[i] instanceof MultipartFile) {
							MultipartFile multipartFile = (MultipartFile) args[i];
							postparams.append(args[i].getClass().getName()).append("{").append("\"part\":")
									.append(multipartFile.getName()).append(",").append("\"filename\":").append(multipartFile.getOriginalFilename()).append("}");
						} else if (args[i] instanceof Serializable) {
							postparams.append(JSON.toJSONString(args[i], SerializerFeature.WriteMapNullValue));
						} else {
							postparams.append(args[i].getClass().getName());
						}
						postparams.append(",");
					}
					params = postparams.toString();
				} else if ("GET".equals(method)) {
					params = Objects.nonNull(queryString)? queryString:"";
				}

				if (queryString != null) {
					params = URLDecoder.decode(params, UTF_8);
				}
			}
			logger.info("[请求方法与接口]====>>>>:{},url:{}", method, uri);
			logger.info("[请求参数]====>>>>:" + params.toString());
		} catch (Exception e) {
			logger.error("log error !!", e);
		}
		Object result = pjp.proceed();
		return result;
	}

	// 执行切点之后
	@After("excudeService()")
	public void exAfter(JoinPoint joinPoint) {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		long startTime = (long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		logger.info("[完成处理耗时]====>>>>:" + (endTime - startTime) + "毫秒");
	}

}
