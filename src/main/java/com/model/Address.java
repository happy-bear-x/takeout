package com.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Address extends JdbSimpyFun {
	private static String table = "address";

	public static List<Map<String, String>> getAllAddress(String user) {
		String condition = "user='" + user + "'";
		return simplySelect(table, condition);

	}

	public static Map<String, String> getShopAddress(String shop) {
		String condition = "user='" + shop + "' and type=1 order by addressid desc";
		if (simplySelect(table, condition).size() == 0) {
			return new HashMap<>();
		}
		return simplySelect(table, condition).get(0);
	}

	public static boolean newAddr(String values) {
		
		String column="user,city,area,street,detail,type,tel";
		return SimplyInsert(table, column, values);
	}
	public static Map<String, String> findAddrById(String addrid) {
		String condition="addressid="+addrid;
		return simplySelect(table, condition).get(0);
	}
}
