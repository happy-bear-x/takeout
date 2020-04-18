package com.model;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User extends JdbSimpyFun {

	private static String table = "user";

	public static boolean insert(List<String> list) {
		String sql = "insert into user (name,psw,birth,headpic,type,sex,nicname) values(?,?,?,?,?,?,?)";
		try {
			prst = getPreStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				prst.setString(i + 1, list.get(i));
			}
			prst.executeUpdate();
			prst.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public static Map<String, String> login(String name, String psw) {
		Map<String, String> map = null;
		String sql = "select nicname,type,headpic from user where name= ? and psw= ?";
		try {
			prst = getPreStatement(sql);
			prst.setString(1, name);
			prst.setString(2, psw);
			System.out.println(name);
			rs = prst.executeQuery();
			if (rs.next()) {
				map = getRsMap(rs);
				return map;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new HashMap<>();
		}
		return map;
	}

	public static Map<String, String> login(String name) {
		Map<String, String> map = null;
		String sql = "select nicname,type,headpic from user where name= ?;";
		try {
			prst = getPreStatement(sql);
			prst.setString(1, name);
			rs = prst.executeQuery();
			if (rs.next()) {
				map = getRsMap(rs);
				return map;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new HashMap<>();
		}
		return map;
	}

	public static Map<String, String> getUserInfo(String name) {
		Map<String, String> map = null;
		String sql = "select * from user where name= ?;";
		try {
			prst = getPreStatement(sql);
			prst.setString(1, name);
			rs = prst.executeQuery();
			if (rs.next()) {
				map = getRsMap(rs);
				return map;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new HashMap<>();
		}
		return map;
	}

	public static boolean isexist(String name) {
		String sql = "select * from user where name= ?";
		try {
			prst = getPreStatement(sql);
			prst.setString(1, name);
			rs = prst.executeQuery();
			if (rs.next()) {
				System.out.println("用户名存在");
				return true;
			} else {
				System.out.println("该用户名可以使用");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("查询异常");
			return true;
		}
	}

	public static int getUserId(String name) {
		String sql = "select * from user where name= ?";
		try {
			prst = getPreStatement(sql);
			prst.setString(1, name);
			rs = prst.executeQuery();
			return rs.getInt("userid");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("查询异常");
			return 0;
		}
	}

	public static boolean updateheadpic(String user, String headpic) {
		String kv = "headpic='" + headpic + "'";
		String condition = "name='" + user + "'";
		return SimplyUpdate(table, kv, condition);
	}

	public static boolean updatePsw(String name, String oldpsw,String newpsw) {
		String kv="psw='" + newpsw + "'";
		String condition="name='" + name + "' and psw='"+oldpsw+"'";
		return SimplyUpdate(table, kv, condition);
	}

	public static boolean updateInfo(List<String> list,String condition) {
		String kv="";
		kv+="sex='"+list.get(0)+"', ";
		kv+="tel='"+list.get(1)+"', ";
		kv+="nicname='"+list.get(2)+"', ";
		kv+="birth='"+list.get(3)+"' ";
		return SimplyUpdate(table, kv, condition);
	}
	public static boolean reSetPsw(String user,String tel,String newpsw) {
		String kv="psw='" + newpsw + "'";
		String condition="name='" + user + "' and tel='"+tel+"'";;
		return SimplyUpdate(table, kv, condition);
	}
	public static String getNicName(String name) {
		String condition="name='"+name+"'";
		return oneColumnSelect("nicname", table, condition).get(0);
	}
}
