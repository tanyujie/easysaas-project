package org.easymis.easyicc.common.sms;

import lombok.Data;

import java.io.Serializable;

@Data
public class SmsResult implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4891653427925609567L;
	private String Result;
    private String phoneCode;
}
