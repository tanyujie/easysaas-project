package org.easymis.easycrm.operation.utils;

import java.util.UUID;

public class UUIDUtil {
	public static String getRandomNum() {
		String s = UUID.randomUUID().toString();
		s = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
		return s.substring(0, 12);
	}
	public static String get32() {
		String s = UUID.randomUUID().toString();
		return s.replaceAll("\\-", "");
	}
}
