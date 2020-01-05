package org.easymis.easycrm.common.advice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.easymis.easycrm.common.security.RestResult;
import org.easymis.easycrm.common.security.ResultCode;
import org.easymis.easycrm.common.security.exception.HasUpperLimitException;
import org.easymis.easycrm.common.security.exception.NotLoginException;
import org.easymis.easycrm.common.security.exception.NotVipException;
import org.easymis.easycrm.common.security.exception.UnknownPrincipalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * 处理全局异常 <br/>
 *
 * @author zh
 */

@RestControllerAdvice
public class GlobalExceptionControllerAdvice {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestResult processException(NativeWebRequest request, Exception e) {
        logger.error("拦截异常", e);
        RestResult restResult = new RestResult();
        restResult.error(e.getMessage());
        return restResult;
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestResult processException(NativeWebRequest request, RuntimeException e) {
        logger.error("拦截异常", e);
        RestResult restResult = new RestResult();
        restResult.error(e.getMessage());
        return restResult;
    }

    @ExceptionHandler({IOException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestResult processException(NativeWebRequest request, IOException e) {
        logger.error("拦截异常", e);
        RestResult restResult = new RestResult();
        restResult.error("服务器出错了，请重试");
        return restResult;
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResult processException(NativeWebRequest request, BindException e) {
        logger.error("拦截异常", e);
        BindingResult result = e.getBindingResult();
        List<FieldError> list = result.getFieldErrors();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            FieldError error = list.get(i);
            buffer.append(error.getField()).append(":").append(error.getDefaultMessage()).append(";");
        }
        RestResult restResult = new RestResult();
        restResult.error(buffer.toString());
        return restResult;
    }

    @ExceptionHandler(ConversionNotSupportedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestResult processException(NativeWebRequest request, ConversionNotSupportedException e) {
        logger.error("拦截异常", e);
        RestResult restResult = new RestResult();
        restResult.error(e.getMessage());
        return restResult;
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public RestResult processException(NativeWebRequest request, HttpMediaTypeNotAcceptableException e) {
        logger.error("拦截异常", e);
        RestResult restResult = new RestResult();
        restResult.error(e.getMessage());
        return restResult;
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public RestResult processException(NativeWebRequest request, HttpMediaTypeNotSupportedException e) {
        logger.error("拦截异常", e);
        RestResult restResult = new RestResult();
        restResult.error(e.getMessage());
        return restResult;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResult processException(NativeWebRequest request, HttpMessageNotReadableException e) {
        logger.error("拦截异常", e);
        RestResult restResult = new RestResult();
        restResult.error(e.getMessage());
        return restResult;
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestResult processException(NativeWebRequest request, HttpMessageNotWritableException e) {
        logger.error("拦截异常", e);
        RestResult restResult = new RestResult();
        restResult.error(e.getMessage());
        return restResult;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public RestResult processException(NativeWebRequest request, HttpRequestMethodNotSupportedException e) {
        logger.error("拦截异常", e);
        RestResult restResult = new RestResult();
        restResult.error(e.getMessage());
        return restResult;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestResult processException(NativeWebRequest request, MissingServletRequestParameterException e) {
        logger.error("拦截异常", e);
        RestResult restResult = new RestResult();
        restResult.error(e.getMessage());
        return restResult;
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestResult processException(SQLException e) {
        RestResult restResult = new RestResult();
        restResult.error(e.getMessage());
        return restResult;
    }

    @ExceptionHandler(TypeMismatchException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestResult processException(NativeWebRequest request, TypeMismatchException e) {
        logger.error("拦截异常", e);
        RestResult restResult = new RestResult();
        restResult.error(e.getMessage());
        return restResult;
    }

    @ExceptionHandler(NotLoginException.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResult  processException(NativeWebRequest request, NotLoginException e){
        logger.error("拦截异常", e);
       // RestResult restResult = new RestResult();
        RestResult restResult= RestResult.buildSc_forbidden("登录查看更多!");
        return restResult;
    }

    @ExceptionHandler(NotVipException.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResult  processException(NativeWebRequest request, NotVipException e){
        logger.error("拦截异常", e);
        RestResult restResult = new RestResult(ResultCode.VALUEADDEDFAIL, "查看更多内容请购买会员", false);
        //restResult.error("请登录!");
        return restResult;
    }

    @ExceptionHandler(UnknownPrincipalException.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResult  processException(NativeWebRequest request, UnknownPrincipalException e){
        HttpServletRequest httpServletRequest =(HttpServletRequest) request.getNativeRequest();
        logger.error("配置url错误: anony 访问了必须要登录的才能访问的资源,path={}",httpServletRequest.getRequestURI());
       // logger.error("拦截异常", e);
        RestResult restResult = new RestResult();

        restResult.forbidden("您访问了必须要登录才能查看的资源!");
        return restResult;
    }

    @ExceptionHandler(HasUpperLimitException.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResult  processException(NativeWebRequest request, HasUpperLimitException e){
        logger.error("拦截异常", e);
        //RestResult restResult = new RestResult();
        RestResult restResult= RestResult.buildFail(e.getMessage());
        return restResult;
    }



}
