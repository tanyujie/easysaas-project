package org.easymis.easyicc.common.result.exception;

/**
 * @author wei.yong
 * @date 2019-02-21 11:24
 */
public interface ResultEnum {

    /**
     * 获取编码: default:0000000
     * @return java.lang.String
     * @author yueli
     * @date 2019-02-21 11:23
     */
    default String getCode() {
        return CommConstants.OK;
    }

    /**
     * 获取提示信息: default:SUCCESS
     * @return java.lang.String
     * @author yueli
     * @date 2019-02-21 11:23
     */
    default String getMsg() {
        return CommConstants.OK_MSG;
    }

}