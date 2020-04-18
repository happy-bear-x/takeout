package com.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.config.Jdbc;

public class JdbSimpyFun extends Jdbc {
	// 快捷运行sql方法
	public static ResultSet query(String sql) {
		prst = getPreStatement(sql);
		try {
			prst = conn.prepareStatement(sql);
			return prst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean isupdate(String sql) {
		prst = getPreStatement(sql);
		try {
			if (prst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 将JDBC获取的ResultSet转化为Map对象。
	// 传入一个下标已经移动到数据的ResultSet，即已经rs.next，返回字段名为key，内容为value的map
	public static Map<String, String> getRsMap(ResultSet rs) throws SQLException {
		Map<String, String> map = new HashMap<>();
		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			map.put(rsmd.getColumnName(i), rs.getString(i));
		}
		return map;

	}

	// 快速单字段查询
	public static List<String> oneColumnSelect(String column, String table, String condition) {
		List<String> list = new ArrayList<>();
		sql = "select " + column + " from `" + table + "` where " + condition;
		rs = query(sql);
		try {
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}

	}

	/**
	 * 公用查询方法，传入表名及条件如select("user","name='user01'")，返回字段为key，内容为value的map链表
	 * 
	 * @param table
	 *            表名
	 * @param condition
	 *            条件，如果条件为空可写为0=0
	 * @return 返回字段为key，内容为value的map链表
	 */
	public static List<Map<String, String>> simplySelect(String table, String condition) {
		Map<String, String> map;
		List<Map<String, String>> list = new ArrayList<>();
		sql = "select * from `" + table + "` where " + condition;
		rs = query(sql);
		try {
			while (rs.next()) {
				map = getRsMap(rs);
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
		return list;
	}

	/**
	 * 快速向表插入内容，传入格式例如：insert(table,column,values) 字段名为 sql关键字是需加上``
	 * 
	 * @param table
	 *            表名无需加`` 如：String table="order";
	 * @param column
	 *            字段名，若为sql关键字需要加上``,如：String column="name,`order`";
	 * @param values
	 *            值，需根据内容自行判断是否加上修饰符，如为varchar需加上''如：String values="'user',101";
	 * @return 如果有数据插入返回true，否则返回false
	 */
	public static boolean SimplyInsert(String table, String column, String values) {
		sql = "insert into `" + table + "` (" + column + ") values(" + values + ")";
		return isupdate(sql);
	}

	/**
	 * 简单update
	 * 
	 * @param table
	 *            表名
	 * @param kv
	 *            需要修改的键值对，键为字段名，值为内容 如：user='user01'。
	 * @param condition
	 *            条件如不需要可写为1=1
	 * @return 有修改返回true，没有修改则返回false。
	 */
	public static boolean SimplyUpdate(String table, String kv, String condition) {
		sql = "update `" + table + "` set " + kv + " where " + condition;
		return isupdate(sql);

	}

}
