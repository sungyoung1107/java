package com.kbstar.frame;

public class Sql {

	public static String deleteSql =  "DELETE FROM cust WHERE id =?";
	public static String insertSql = "INSERT INTO cust VALUES(?,?,?,?)";
	public static String updateSql = "UPDATE cust SET pwd=?, name=?, age=? WHERE id =?";
	public static String selectAllsSql = "SELECT * from cust";
	public static String selectSql = "SELECT * from cust WHERE id=?";
	
}
