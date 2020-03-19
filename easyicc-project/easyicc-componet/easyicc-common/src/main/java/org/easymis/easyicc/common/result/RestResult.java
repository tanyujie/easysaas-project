package org.easymis.easyicc.common.result;

import java.io.Serializable;

/**
 * Rest返回结果
 */
public class  RestResult implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
    private String msg;
    private Object data;

    public RestResult() {

    }

    public RestResult(String code, String msg, boolean flag) {
        this.code = code;
        this.msg = msg;
        this.data = "";
    }

    public RestResult(String code, String msg, Object data, boolean flag) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static RestResult buildSuccess() {
        RestResult restResult = new RestResult();
        restResult.success();
        return restResult;
    }

    public static RestResult buildSuccess(Object t) {
        RestResult restResult = buildSuccess();
        restResult.setData(t);
        return restResult;
    }
    public static RestResult buildSuccess(String msg,Object t) {
        RestResult restResult = buildSuccess();
        restResult.setMsg(msg);
        restResult.setData(t);
        return restResult;
    }
    public static RestResult buildError() {
        RestResult restResult = new RestResult();
        restResult.error();
        return restResult;
    }

    public static RestResult buildError(String msg) {
        RestResult restResult = new RestResult();
        restResult.error(msg);
        return restResult;
    }

    public static RestResult buildFail() {
        RestResult restResult = new RestResult();
        restResult.fail();
        return restResult;
    }

    public static RestResult buildFail(String msg) {
        RestResult restResult = buildFail();
        restResult.fail(msg);
        return restResult;
    }
    public static RestResult buildError(String msg,Object data) {
        RestResult restResult = new RestResult();
        restResult.error(msg);
        restResult.setData(data);
        return restResult;
    }
    public static RestResult buildOAuthFail() {
        RestResult restResult = new RestResult();
        restResult.authFail();
        return restResult;
    }


    public RestResult success() {
        this.code = ResultCode.SUCCESS;
        this.msg = "成功";
        this.data = "";
        return this;
    }

    public RestResult success(String msg) {
        this.code = ResultCode.SUCCESS;
        this.msg = msg;
        this.data = "";
        return this;
    }

    public RestResult success(Object data) {
        success();
        this.data = data;
        return this;
    }

    public RestResult fail() {
        this.code = ResultCode.FAIL;
        this.msg = "失败";
        this.data = "";
        return this;
    }

    public RestResult authFail() {
        this.code = ResultCode.OAUTHFAIL;
        this.msg = "请重新登录";
        this.data = "";
        return this;
    }

    public RestResult fail(String msg) {
        this.code = ResultCode.FAIL;
        this.msg = msg;
        this.data = "";
        return this;
    }

    public RestResult error() {
        this.code = ResultCode.ERROR;
        this.msg = "服务异常";
        this.data = "";
        return this;
    }

    public RestResult authFail2() {
        this.code = ResultCode.OAUTHFAIL;
        this.msg = "请重新登录";
        this.data = "";
        return this;
    }

    public RestResult error(String msg) {
        this.code = ResultCode.ERROR;
        this.msg = msg;
        this.data = "";
        return this;
    }

    public RestResult forbidden(String msg) {
        this.code = ResultCode.SC_FORBIDDEN;
        this.msg = msg;
        this.data = "";
        return this;
    }

    public static RestResult buildOAuthFail2() {
        RestResult restResult = new RestResult();
        restResult.authFail2();
        return restResult;
    }

    public static RestResult buildSc_forbidden(String msg) {
        RestResult restResult = new RestResult();
        restResult.forbidden(msg);
        return restResult;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
