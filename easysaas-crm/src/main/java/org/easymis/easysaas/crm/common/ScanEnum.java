package org.easymis.easysaas.crm.common;

/**
 * 二维码扫描状态常量
 *
 * @author wangkai  2019/7/20
 */
public enum  ScanEnum {

    /**
     * 默认状态,未扫描二维码
     */
    WAIT_SCAN(1,"未扫描"),

    /**
     * 已扫描二维码，等待确认登录
     */
    WAIT_LOGIN(2,"已经扫描,待登录"),

    /**
     * 确认登录
     */
    LOGIN(3,"确认登录");

    private int type;
    private String status;

    ScanEnum(int i, String status) {
        this.type = i;
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }
}
