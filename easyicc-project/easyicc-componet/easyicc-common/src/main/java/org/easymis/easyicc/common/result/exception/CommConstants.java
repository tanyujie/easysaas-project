package org.easymis.easyicc.common.result.exception;

/**
 * 公共常量类
 *
 * @author S.J.
 * @date 2019/02/20
 */
public class CommConstants {

	public static final String RET_CODE = "retCode";
	public static final String RET_MSG = "retMsg";
	public static final String RESULT = "result";

	//操作成功-7个0-返回给app接口
	public static final String OK = "0000000";
	//操作成功
	public static final String OK_MSG = "success";

	//-1
	public static final String NEGATIVE_ONE = "-1";

	//分号
	public static final String SEMICOLON = ";";
	//逗号
	public static final String COMMOA = ",";
	//点号
  	public static final String DOT = ".";
  	//斜杠
  	public static final String SLASH = "/";
  	//零-0
  	public static final String ZREO = "0";

	//Content-Type
	public static final String CONTENT_TYPE = "Content-Type";

	//60秒 1分钟(60)
	public static final Integer ONE_MINUTE_TIME = 60;

	//300秒 5分钟(5*60)
	public static final Integer FIVE_MINUTE_TIME = 300;

	//600秒 10分钟(10*60)
	public static final Long TEN_MINUTE_TIME = 300L;

	//3600秒 1小时(1*60*60)
	public static final Integer ONE_HOUR_TIME = 3600;
	//7200秒 2小时(2*60*60)
	public static final Integer TWO_HOUR_TIME = 7200;
	//86400秒 24小时(24*60*60)
	public static final Integer TWENTY_FOUR_HOUR_TIME = 86400;

	//token
	public static final String TOKEN = "token";
	//webtoken
	public static final String WEB_TOKEN = "webtoken";

	//claims
	public static final String CLAIMS = "claims";
	//sharepanzer
	public static final String SHAREPANZER = "sharepanzer";

	public static final String USER_ID = "userId";
	public static final String USER_ACCOUNT = "userAccount";
	public static final String USER_NAME = "userName";
	public static final String BASE_USER_ID = "baseUserId";
	public static final String BASE_USER_ACCOUNT = "baseUserAccount";
	public static final String OPEN_USER_ID = "openUserId";
	public static final String OPEN_USER_ACCOUNT = "openUserAccount";
	public static final String MANAGE_USER_ID = "manageUserId";
	public static final String MANAGE_USER_ACCOUNT = "manageUserAccount";
	public static final String API_USER_ID = "apiUserId";
	public static final String API_USER_ACCOUNT = "apiUserAccount";
	public static final String SOURCE_TYPE = "sourceType";

	//签名
	public static final String KEY = "key";
	public static final String API_SECRET = "apiSecret";
	public static final String API_CODE = "apiCode";
	public static final String TIMESTAMP = "timestamp";
	public static final String SIGN = "sign";
	public static final String SIGN_TYPE = "signType";
	public static final String EUQAL = "=";
	public static final String AND = "&";

  	/*----------------------------- 系统统一错误编码 -----------------------------*/
    /**
     * 错误编码-系统错误
     */
    public static final String SYSTEM_ERROR = "00000001";
    /**
     * 错误描述-系统错误
     */
    public static final String SYSTEM_ERROR_MSG = "系统太忙了，请稍后重试";
//    public static final String SYSTEM_ERROR_MSG = "服务竟然出错了，请刷新页面";

    /**
     * 错误编码-数据操作失败(数据不存在)
     */
    public static final String DATABASE_ERROR = "00000002";
    /**
     * 错误描述-数据操作失败(数据不存在)
     */
    public static final String DATABASE_ERROR_MSG = "数据操作失败";

    /**
     * 错误编码-数据不存在
     * 数据库操作失败通用型编码，如果需要返回详细错误，请使用详细错误编码
     */
    public static final String DATABASE_NOTEXIST = "00000003";
    /**
     * 错误描述-数据不存在
     */
    public static final String DATABASE_NOTEXIST_MSG = "数据不存在";

    /*----------------------------- 系统统一错误编码 -----------------------------*/

}