package com.model;

public class Account extends JdbSimpyFun {
	private static String table="account";
	public static double getWallet(String user) {
		sql = "select wallet from account where user='" + user + "';";
		rs = query(sql);
		try {
			rs.next();
			return rs.getDouble(1);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static boolean spend(String user, double price) {
		return SimplyUpdate(table, "wallet =wallet-" + price, "user='" + user + "'");
	}

	public static boolean earn(String user, String money) {
		return SimplyUpdate(table, "wallet =wallet+" + money, "user='" + user + "'");
	}
}
