package com.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Voucher extends JdbSimpyFun {
	private static String table="voucher";
	public static List<Map<String, String>> getAllUsableVoucher(String user,String money) {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> voucher;
		sql = "select id,worth,endtime,`condition`,shop from voucher where user='" + user
				+ "' and endtime>now() and isused=0 and `condition`<="+money+";";
		rs = query(sql);
		try {
			while (rs.next()) {
				voucher = getRsMap(rs);
				list.add(voucher);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean spend(String id) {
		sql = "update voucher set isused=1 where id=" + id;
		return isupdate(sql);
	}
	public static String getWorth(String id,String user) {
		String condition="id="+id+" and user='"+user+"';";
		return oneColumnSelect("worth", table, condition).get(0);
		
	}
	public static boolean newVoucher(String user, String worth, String day,String condition) {
		sql = "insert into voucher (user,worth,endtime,`condition`) values('" + user + "'," + worth + ",date_add(now(),interval " + day
				+ " day),'"+condition+"')";
		return isupdate(sql);
	}

	public static boolean newVoucher(String user, String worth, String day,String condition, String shop) {
		sql = "insert into voucher (user,worth,endtime,`condition`,shop) values('" + user + "'," + worth + ",date_add(now(),interval "
				+ day + " day),'"+condition+"','" + shop + "')";
		return isupdate(sql);
	}
}
