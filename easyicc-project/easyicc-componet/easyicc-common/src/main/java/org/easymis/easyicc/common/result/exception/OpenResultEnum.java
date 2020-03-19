package org.easymis.easyicc.common.result.exception;

public enum OpenResultEnum implements ResultEnum {

	UNKNOWN_ERROR("-1", "unknown exception"),
	SUCCESS(CommConstants.OK, CommConstants.OK_MSG),
	SYSTEM_ERROR(CommConstants.SYSTEM_ERROR, CommConstants.SYSTEM_ERROR_MSG),
	DATABASE_ERROR(CommConstants.DATABASE_ERROR, CommConstants.DATABASE_ERROR_MSG),
	DATABASE_NOTEXIST(CommConstants.DATABASE_NOTEXIST, CommConstants.DATABASE_NOTEXIST_MSG),
	PARAMETER_EMPTY("1000001", "传入参数为空"),
	PARAMETER_ERROR("1000002", "传入参数错误"),

	USER_ACCOUNT_NOTEXIST("1010001", "您的账号不存在"),
	USER_ACCOUNT_EXIST("1010002", "您已经注册过"),
	USER_ACCOUNT_FREEZE("1010003", "您的账户已禁用"),
	USER_ACCOUNT_RESTORE("1010004", "您的账户已启用"),
	USER_FIRST_LOGIN_ERROR("1010004", "您好，首次登陆请修改密码"),
	USER_MOBILE_EXIST("1010005", "手机号码已存在"),
	USER_PASSWORD_ERROR("1010006", "您的密码错误"),
	USER_ACCOUNT_PASSWORD_ERROR("1010007", "您的账户或密码错误"),
	USER_API_EXIST("1010008", "用户api接口已存在"),

	ENTERPRISE_NOTEXIST("1020001", "您没有注册企业"),
	ENTERPRISE_EXIST("1020002", "您已经注册企业"),
	ENTERPRISE_SOCIAL_CODE_EXIST("1020003", "企业社会信用代码已存在"),
	BASE_USER_ACCOUNT_PASSWORD_ERROR("1020004", "您的账户或密码错误"),

	API_JSON_ERROR("1030001", "详情内容非JSON"),
	API_DOWN("1030002", "api接口已下架"),
	API_UP("1030003", "api接口已上架"),


	;

	private String code;

	private String msg;

	private OpenResultEnum(String code, String msg) {
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