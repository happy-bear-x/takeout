package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {
	//此处可更改数据库内容
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/wm?useUnicode=true&characterEncoding=UTF-8";
	private static String username = "wm";
	private static String password = "xcd1996";
	public static Connection conn = null;
	public static PreparedStatement prst = null;
	public static String sql = null;
	public static ResultSet rs = null;

	public static Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static PreparedStatement getPreStatement(String sql) {
		try {
			prst = getConnection().prepareStatement(sql);
			return prst;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
