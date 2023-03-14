package com.kbstar.frame;

public class Sql {

	// Cust DML
	public static String deleteSql =  "DELETE FROM cust WHERE id =?";
	public static String insertSql = "INSERT INTO cust VALUES(?,?,?,?)";
	public static String updateSql = "UPDATE cust SET pwd=?, name=?, age=? WHERE id =?";
	public static String selectAllsSql = "SELECT * from cust";
	public static String selectSql = "SELECT * from cust WHERE id=?";
	
	// Item DML
	public static String itemdeleteSql =  "DELETE FROM item WHERE id =?";
	public static String iteminsertSql = "INSERT INTO item VALUES(?,?,?,?,SYSDATE)";
	public static String itemupdateSql = "UPDATE item SET name=?, price=?, rate=? WHERE id=?";
	public static String itemselectAllsSql = "SELECT * from item";
	public static String itemselectSql = "SELECT * from item WHERE id=?";
	
}
