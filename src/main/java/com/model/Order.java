package com.model;

import java.util.List;
import java.util.Map;

public class Order extends JdbSimpyFun {
	private static String table = "order";

	// 简单插入新的订单无代金卷
	public static boolean newOrder(String ordernum,String user,String shop,String foodid,String num,double pay,String total,String addressid) {
		String column="ordernum,user,shop,foodid,num,pay,total,addressid";
		String values="'"+ordernum+"','"+user+"','"+shop+"',"+foodid+","+num+","+pay+","+total+","+addressid;
		return SimplyInsert(table, column, values);
		
	}
	//使用代金卷
	public static boolean useVoucher(String ordernum, String worth) {
		sql="update set `voucher`="+worth+" where ordernum='"+ordernum+"'";
		return isupdate(sql);
	}
	//删除订单
	public static boolean delOrder(String ordernum) {
		sql="delete from `order` where ordernum='"+ordernum+"';";
		return isupdate(sql);
	}
	
	//将订单变为配送状态
	public static boolean changeTakingOrder(String ordernum) {
		String condition="ordernum='"+ordernum+"'";
		String kv="state=1";
		return SimplyUpdate(table, kv, condition);
	}
	
	//取消订单(用户)
	public static boolean cancelOrder(String ordernum) {
		String condition="ordernum='"+ordernum+"'";
		String kv="state=-1";
		return SimplyUpdate(table, kv, condition); 
	}
	
	//订单变为取消状态（完成取消）
	public static boolean finishCancelOrder(String ordernum) {
		String condition="ordernum='"+ordernum+"'";
		String kv="state=-2";
		return SimplyUpdate(table, kv, condition); 
	}
	
	//将订单变为完成状态（可评价）
	public static boolean changeRecOrder(String ordernum) {
		String condition="ordernum='"+ordernum+"'";
		String kv="state=2";
		return SimplyUpdate(table, kv, condition);
	}
	
	public static boolean finishOrder(String ordernum) {
		String condition="ordernum='"+ordernum+"'";
		String kv="state=3 finishtime=new()";
		return SimplyUpdate(table, kv, condition);
	}
	
	// 获取用户所有订单的list，单次限制3个
	public static List<Map<String, String>> getAllOrder(String user,String start) {
		String condition = "user='" + user + "' group by ordernum  order by ordernum desc limit "+start+",3";
		return simplySelect(table, condition);

	}
	public static List<Map<String, String>> getShopOrder(String shop,String start) {
		String condition = "shop='" + shop + "' group by ordernum  order by ordernum desc limit "+start+",3";
		return simplySelect(table, condition);

	}
	
	public static Map<String, String> findOrderByNum(String ordernum) {
		String condition="ordernum='"+ordernum+"' order by ordernum";
		return simplySelect(table, condition).get(0);
		
	}
	// 获取用户未完成的订单的list
	public static List<Map<String, String>> getGoingOrder(String user) {
		String condition = "user='" + user + "' and state=0";
		return simplySelect(table, condition);

	}
	public static void userReason(String ordernum,String reason) {
		String condition="ordernum='"+ordernum+"'";
		String kv="uaddition='"+reason+"'";
		SimplyUpdate(table, kv, condition);
	}
	public static void shopReason(String ordernum,String reason) {
		String condition="ordernum='"+ordernum+"'";
		String kv="saddition='"+reason+"'";
		SimplyUpdate(table, kv, condition);
	}
	public static List<Map<String, String>> findOrderListByNum(String ordernum) {
		String condition="ordernum='"+ordernum+"'";
		return simplySelect(table, condition);
		
	}
}
