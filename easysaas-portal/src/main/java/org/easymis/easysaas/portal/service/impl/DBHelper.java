package org.easymis.easysaas.portal.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {

	public static final String url = "jdbc:mysql://127.0.0.1:3307/easycompany?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true&zeroDateTimeBehavior=convertToNull";
	public static final String name = "com.mysql.cj.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "root";

	public static Connection conn = null;

	public static Connection getConn() {
		try {
			Class.forName(name);
			conn = DriverManager.getConnection(url, user, password);// ��ȡ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static Connection getCompanyConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://127.0.0.1:3307/easycompany?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true&zeroDateTimeBehavior=convertToNull";
			conn = DriverManager.getConnection(dbUrl, user, password);// ��ȡ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static Connection getDishonestConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://127.0.0.1:3307/easycompany?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true&zeroDateTimeBehavior=convertToNull";
			conn = DriverManager.getConnection(dbUrl, user, password);// ��ȡ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
