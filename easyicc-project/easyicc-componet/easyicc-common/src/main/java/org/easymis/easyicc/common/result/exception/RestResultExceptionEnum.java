package org.easymis.easyicc.common.result.exception;

public enum RestResultExceptionEnum implements ResultEnum {

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

	USER_FIRST_LOGIN_CHANGE_PASSWORD("0000009", "您好，首次登陆请修改密码"),
	USER_FIRST_LOGIN_CHANGE_PASSWORD_EXPIRE("0000010", "设置密码已过期"),
	USER_FIRST_LOGIN_CHANGE_PASSWORD_ILLEGAL("0000011", "密码非法法修改"),
	FILE_MAX_UPLOAD_MAX_EXCEED_ERROR("0000012", "文件大小超过100M限制"),

	USER_PASSWORD_RULE("0000013", "密码长度为6到20位，必须包含数字、小写字母、大写字母"),
	USER_PASSWORD_NOT_EQUQAL("0000014", "密码和确认密码不一致"),
	USER_PASSWORD_OLD_ERROR("0000015", "原密码错误"),

	ALIYUN_SMS_ERROR("0000015", "短信发送失败"),
	ELASTIC_SEARCH_MAXRECORD("0000016", "超出ElasticSearch最大记录限制"),
	;

	private String code;

	private String msg;

	private RestResultExceptionEnum(String code, String msg) {
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
	@Override
	public String getMsg() {
		return this.msg;
	}

}