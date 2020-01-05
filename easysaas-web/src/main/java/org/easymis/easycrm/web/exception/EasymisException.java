package org.easymis.easycrm.web.exception;

/**
 * 自定义异常
 * 
 * @date 2016年10月27日 下午10:11:27
 */
public class EasymisException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String code;// 异常状态码
	private String message; // 异常信息
	private String method; // 发生的方法，位置等
	private String descinfo; // 描述

	public EasymisException(String code, String message, String method, String descinfo) {
		super();
		this.code = code;
		this.message = message;
		this.method = method;
		this.descinfo = descinfo;
	}

	public EasymisException(String message) {
		super(message);
		this.message = message;
	}

	public EasymisException(String message, Throwable e) {
		super(message, e);
		this.message = message;
	}

	public EasymisException(String message, String code) {
		super(message);
		this.message = message;
		this.code = code;
	}

	public EasymisException(String message, String code, Throwable e) {
		super(message, e);
		this.message = message;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDescinfo() {
		return descinfo;
	}

	public void setDescinfo(String descinfo) {
		this.descinfo = descinfo;
	}

}
