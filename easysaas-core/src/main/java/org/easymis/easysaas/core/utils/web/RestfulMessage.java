package org.easymis.easysaas.core.utils.web;

import java.io.Serializable;

/**
 * API统一返回值类
 *
 */
public class RestfulMessage implements Serializable {

	private String msg;
	private String cause;
	private Integer code;
	private Object data;// 数据
	public RestfulMessage()
	{
		this.code=ResultCode.SUCCESS.code();
		this.msg=ResultCode.SUCCESS.message();
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	// 成功，不返回具体数据
	/**
	 * 成功，不返回具体数据
	 * @return: 
	 */
	public static RestfulMessage success() {
		RestfulMessage result = new RestfulMessage();
		result.setResultCode(ResultCode.SUCCESS);
		return result;
	}
	// 成功，不返回具体数据
	/**
	 * 成功，不返回具体数据
	 * @param messgae 成功信息
	 * @return: 
	 */
	public static RestfulMessage success(String messgae) {
		RestfulMessage result = new RestfulMessage();
		result.setResultCode(ResultCode.SUCCESS);
		result.setMsg(messgae);
		return result;
	}
	public static RestfulMessage success(int code,String messgae) {
		RestfulMessage result = new RestfulMessage();
		result.setResultCode(ResultCode.SUCCESS);
		result.setCode(code);
		result.setMsg(messgae);
		return result;
	}
	// 成功，返回数据
	/**
	 * 成功，返回数据
	 * @param data 数据
	 * @return: 
	 */
	public static RestfulMessage success(Object data) {
		RestfulMessage result = new RestfulMessage();
		result.setResultCode(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}

	// 成功，返回数据
	/**
	 * 成功，返回成功信息和数据
	 * @param message 成功信息
	 * @param data 数据
	 * @return: 
	 */
	public static RestfulMessage success(String message, Object data) {
		RestfulMessage restMessgae = new RestfulMessage();
		restMessgae.setCode(1);
		restMessgae.setMsg(message);
		restMessgae.setData(data);
		return restMessgae;
	}

	/**
	 * 成功，返回成功编码
	 * @param resultCode 成功编码
	 * @return: 
	 */
	public static RestfulMessage failure(ResultCode resultCode) {
		RestfulMessage result = new RestfulMessage();
		result.setResultCode(resultCode);
		return result;
	}

	/**
	 * 失败，返回错误编码和错误数据
	 * @param resultCode 错误编码
	 * @param data 错误数据
	 * @return: 
	 */
	public static RestfulMessage failure(ResultCode resultCode, Object data) {
		RestfulMessage result = new RestfulMessage();
		result.setResultCode(resultCode);
		result.setData(data);
		return result;
	}



	/**
	 * 失败，返回失败信息
	 * @param message 失败信息
	 * @return: 
	 */
	public static RestfulMessage failure(String message) {
		RestfulMessage restMessgae = new RestfulMessage();
		restMessgae.setCode(0);
		restMessgae.setMsg(message);
		return restMessgae;
	}
	public static RestfulMessage failure(int code,String cause) {
		RestfulMessage restMessgae = new RestfulMessage();
		restMessgae.setCode(code);
		restMessgae.setCause(cause);
		return restMessgae;
	}
	public static RestfulMessage failure(String message,String cause) {
		RestfulMessage restMessgae = new RestfulMessage();
		restMessgae.setCode(0);
		restMessgae.setMsg(message);
		restMessgae.setCause(cause);
		return restMessgae;
	}
	/**
	 * 失败，返回失败信息和数据
	 * @param message 失败信息
	 * @param data 数据
	 * @return: 
	 */
	public static RestfulMessage failure(String message,String cause,Object data) {
		RestfulMessage restMessgae = new RestfulMessage();
		restMessgae.setCode(0);
		restMessgae.setMsg(message);
		restMessgae.setData(data);
		return restMessgae;
	}
	/**
	 * 
	* @Title: failure
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param code 返回编码
	* @param @param message 错误消息
	* @param @param cause 错误提示信息
	* @param @return    设定文件
	* @return RestfulMessage    返回类型
	* @throws
	 */
	public static RestfulMessage failure(int code,String message,String cause) {
		RestfulMessage restMessgae = new RestfulMessage();
		restMessgae.setCode(code);
		restMessgae.setMsg(message);
		restMessgae.setCause(cause);
		return restMessgae;
	}
	public void setResultCode(ResultCode code) {
		this.code = code.code();
		this.msg = code.message();
	}
}
