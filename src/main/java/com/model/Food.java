package com.model;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class Food extends JdbSimpyFun {
	private static String table="foods";
	public static boolean newFood(String shop, String name, String price, String picturepath, String des) {
		String sql = "insert into foods (shop,name,price,pic,des) values('" + shop + "','" + name + "','" + price
				+ "','" + picturepath + "','" + des + "');";
		return isupdate(sql);
	}

	public static boolean updateFood(String foodid, String name, String price, String picturepath, String des) {
		String sql = "update foods set name=?,price=?,pic=?,des=? where foodid=?;";
		prst = getPreStatement(sql);
		try {
			prst.setString(1, name);
			prst.setString(2, price);
			prst.setString(3, picturepath);
			prst.setString(4, des);
			prst.setString(5, foodid);
			prst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean updateFood(String foodid, String name, String price, String des) {
		String sql = "update foods set name=?,price=?,des=? where foodid=?;";
		prst = getPreStatement(sql);
		try {
			prst.setString(1, name);
			prst.setString(2, price);
			prst.setString(3, des);
			prst.setString(4, foodid);
			prst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static ResultSet findFoodByName(String name) throws UnsupportedEncodingException {
		String sql = "select * from foods where nicname like '%" + name + "%';";
		prst = getPreStatement(sql);
		try {
			return prst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	//通过foodid查询一个food的全部属性
	public static Map<String, String> findFoodById(String foodid) throws UnsupportedEncodingException {
		String sql = "select * from foods where foodid = ?;";
		prst = getPreStatement(sql);
		try {
			prst.setString(1, foodid);
			rs=prst.executeQuery();
			rs.next();
			return getRsMap(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	//通过foodid查询foodname
	public static String getFoodNameById(String foodid) {
		
		String condition="foodid="+foodid;
		return oneColumnSelect("name", table, condition).get(0);
		
	}
	public static List<String> getShopByFoodName(String foodname) {
		
		String column="shop";
		String condition="name like '%"+foodname+"%' group by name;";
		return oneColumnSelect(column, table, condition);
		
	}
}
