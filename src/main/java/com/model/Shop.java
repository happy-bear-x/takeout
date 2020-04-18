package com.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Shop extends JdbSimpyFun {
	private static String table = "user";

	public static ResultSet selectAll() throws SQLException {
		String sql = "select * from user where type= '1'";
		rs = query(sql);
		return rs;
	}

	public static Map<String, String> getOneShop(String name) {
		Map<String, String> map;
		String sql = "select * from user where name= ?";
		try {
			prst = getPreStatement(sql);
			prst.setString(1, name);
			rs = prst.executeQuery();
			rs.next();
			map = getRsMap(rs);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询异常");
			return null;
		}
	}

	public static String getNicName(String name) {
		String sql = "select nicname from user where name= ?";
		try {
			prst = getPreStatement(sql);
			prst.setString(1, name);
			rs = prst.executeQuery();
			rs.next();
			return rs.getString("nicname");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询异常");
			return null;
		}
	}

	public static ResultSet getShopFoods(String name) {
		String sql = "select * from foods where shop= ?";
		try {
			prst = getPreStatement(sql);
			prst.setString(1, name);
			rs = prst.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static List<Map<String, String>> findShopByNicName(String nicname, String start) {
		String condition = "nicname like '%" + nicname + "%' ";
		return simplySelect(table, condition);
	}

	public static List<Map<String, String>> findShopByFoodName(String foodname, String start) {
		List<Map<String, String>> shoplist = new ArrayList<>();
		for (String shop : Food.getShopByFoodName(foodname)) {
			String condition = "name='" + shop + "'";
			shoplist.add(simplySelect(table, condition).get(0));
		}
		return shoplist;
	}
	public static List<String> randShop() {
		List<String> list=new ArrayList<>();
		int rand=(int) (Math.random()+1);
		String condition="1=1 limit "+rand+",1";
		String nicname=simplySelect(table, condition).get(0).get("nicname");
		String headpic=simplySelect(table, condition).get(0).get("headpic");
		String shop=simplySelect(table, condition).get(0).get("name");
		list.add(headpic);
		list.add(nicname);
		list.add(shop);
		return list;
	}
}
