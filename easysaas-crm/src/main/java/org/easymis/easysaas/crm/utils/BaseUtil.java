package org.easymis.easysaas.crm.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseUtil {
    /**
     * 获取当前年月的字符串
     *
     * @return yyyyMMdd
     */
	public static String getDate() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss");
		return now.format(formatter2);
	}
}
