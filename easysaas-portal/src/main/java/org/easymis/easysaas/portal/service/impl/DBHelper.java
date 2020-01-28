package org.easymis.easysaas.portal.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {

	public static final String url = "jdbc:mysql://127.0.0.1:3307/easymis_dbview?useSSL=false";
	public static final String name = "com.mysql.jdbc.Driver";
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
}
