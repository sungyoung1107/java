package com.kbstar.frame;

public class Sql {

	// user DML
	public static String bankuserdeleteSql =  "DELETE FROM bankuser WHERE id =?";
	public static String bankuserinsertSql = "INSERT INTO bankuser VALUES(?,?,?,?)";
	public static String bankuserupdateSql = "UPDATE bankuser SET pw=?, name=?, contact=? WHERE id =?";
	public static String bankuserselectAllSql = "SELECT * from bankuser";
	public static String bankuserselectSql = "SELECT * from bankuser WHERE id=?";
	
	// account DML
	public static String accountdeleteSql =  "DELETE FROM account WHERE accNum =?";
	public static String accountinsertSql = "INSERT INTO account VALUES(?,?,?,?)";
	public static String accountupdateSql = "UPDATE account SET balance =?  WHERE accNum =?";
	public static String myaccountselectAllSql = "SELECT * from account WHERE userId=?"; // 사용자의 모든 계좌 정보
	public static String accountselectSql = "SELECT * from account WHERE accNum=?"; // 계좌에 대한 정보
	
	// transaction DML
	public static String transactioninsertSql = "INSERT INTO transaction VALUES(?,?,?,?,?)";
	public static String transactionselectSql = "SELECT * from transaction WHERE accNum=?"; // 계좌에 대한 거래정보
	
	
}
