package org.easymis.easyicc.common.result.exception;

public enum RetOpenManageResultEnum implements ResultEnum {

	UNKNOWN_ERROR("-1", "unknown exception"),
	SUCCESS(CommConstants.OK, CommConstants.OK_MSG),
	SYSTEM_ERROR(CommConstants.SYSTEM_ERROR, CommConstants.SYSTEM_ERROR_MSG),
	DATABASE_ERROR(CommConstants.DATABASE_ERROR, CommConstants.DATABASE_ERROR_MSG),
	DATABASE_NOTEXIST(CommConstants.DATABASE_NOTEXIST, CommConstants.DATABASE_NOTEXIST_MSG),
	NETWORK_ERROR("0000004", "非法请求"),
	PARAMETER_NULL("0000005", "参数为空"),
	PARAMETER_ERROR("0000005", "参数错误"),
	PARAMETER_TYPE_ERROR("0000005", "参数类型错误"),

	TOKEN_NULL_ERROR("0000006", "token为空"),
	TOKEN_JWT_ERROR("0000007", "token格式错误"),
	TOKEN_VERIFY_FAIL_ERROR("0000007", "token校验失败"),
	TOKEN_ERROR("0000008", "token错误"),
	TOKEN_EXPIRE("0000008", "token已过期"),

	ALIYUN_SMS_ERROR("0000015", "短信发送失败"),

	;

	private String code;

	private String msg;

	private RetOpenManageResultEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return this.msg;
	}

}