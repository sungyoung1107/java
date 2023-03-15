package com.kbstar.frame;

public class Sql {

	// Cust DML
	public static String deleteSql = "DELETE FROM cust WHERE id =?";
	public static String insertSql = "INSERT INTO cust VALUES(?,?,?,?)";
	public static String updateSql = "UPDATE cust SET pwd=?, name=?, age=? WHERE id =?";
	public static String selectAllsSql = "SELECT * from cust";
	public static String selectSql = "SELECT * from cust WHERE id=?";

	// Item DML
	public static String itemdeleteSql = "DELETE FROM item WHERE id =?";
	public static String iteminsertSql = "INSERT INTO item VALUES(?,?,?,?,SYSDATE)";
	public static String itemupdateSql = "UPDATE item SET name=?, price=?, rate=? WHERE id=?";
	public static String itemselectAllsSql = "SELECT * from item";
	public static String itemselectSql = "SELECT * from item WHERE id=?";

	// Car DML
	public static String cartdeleteSql = "DELETE FROM cart WHERE id =?";
	public static String cartinsertSql = "INSERT INTO cart VALUES(?,?,?,?,SYSDATE)";
	public static String cartupdateSql = "UPDATE cart SET item_id=?, cnt=? WHERE id=?";
	public static String cartselectAllsSql = "SELECT * from cart";
	public static String cartselectSql = "SELECT * from cart WHERE id=?";
	public static String mycartselectAllSql = "select * from Cart where user_id=?";

}
