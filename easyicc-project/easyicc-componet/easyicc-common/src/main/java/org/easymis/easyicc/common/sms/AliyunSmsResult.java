package org.easymis.easyicc.common.sms;

import lombok.Data;

import java.io.Serializable;


@Data
public class AliyunSmsResult implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3129845358729136228L;
	private String bizId;
    private String code;
    private String message;
    private String requestId;
    private String phoneCode;
}
