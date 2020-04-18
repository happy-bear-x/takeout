package com.model;

import java.util.List;
import java.util.Map;

public class Judgment extends JdbSimpyFun {
	private static String table="judgment";
	public static boolean newJudge(String values) {
		String column="ordernum,user,shop,score,judge";
		return SimplyInsert(table, column, values);
	}
	public static List<Map<String, String>> getJudgment(String shop,String start) {
		String condition="shop='"+shop+"' limit "+start+",4";
		return simplySelect(table, condition);
	}
}
