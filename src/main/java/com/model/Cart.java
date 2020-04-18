package com.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart extends JdbSimpyFun {
	private static ResultSet rs = null;
	public static PreparedStatement prep = null;

	public static ResultSet isExist(String foodid, String user, String shop) {
		String sql = "select num from cart where foodid=? and user=? and shop=?;";
		try {
			prep = getPreStatement(sql);
			prep.setString(1, foodid);
			prep.setString(2, user);
			prep.setString(3, shop);
			return prep.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean insertFood(String foodid, String user, String shop) {
		String sql = "insert into cart (foodid,user,shop) values(?,?,?) ;";
		try {
			if ((rs = isExist(foodid, user, shop)).next()) {
				sql = "update cart set num=" + (rs.getInt("num") + 1) + " where foodid=? and user=? and shop=?;";
			}
		} catch (SQLException e1) {
			return false;
		}
		try {
			prep = getPreStatement(sql);
			prep.setString(1, foodid);
			prep.setString(2, user);
			prep.setString(3, shop);
			prep.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static List<Map<String, String>> getUserCart(String user, String shop) {
		List<Map<String, String>> list = new ArrayList<>();
		List<String> idlist = new ArrayList<>();
		List<String> numlist = new ArrayList<>();
		String sql = "SELECT foodid,num FROM cart WHERE user='" + user + "' and shop='" + shop + "';";
		try {
			rs = query(sql);
			while (rs.next()) {
				idlist.add(rs.getString(1));
				numlist.add(rs.getString(2));
			}
			for (int i = 0; i < idlist.size(); i++) {
				Map<String, String> map = Food.findFoodById(idlist.get(i));
				map.put("num", numlist.get(i));
				list.add(map);
			}
			rs.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static boolean cleanCart(String user,String shop) {
		sql="delete from cart where user='"+user+"' and shop='"+shop+"';";
		return isupdate(sql);
	}

}
