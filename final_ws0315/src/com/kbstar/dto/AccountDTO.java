package com.kbstar.dto;

public class AccountDTO {
	private String accNum;
	private String accHolder;
	private double balance;
	private String userId;
	
	public AccountDTO() {
	}
	
	public AccountDTO(String accNum) {
		this.accNum = accNum;
	}

	public AccountDTO(String accHolder, double balance) {
		this.accHolder = accHolder;
		this.balance = balance;
	}
	
	
	public AccountDTO(String accHolder, double balance, String userId) {
		this.accHolder = accHolder;
		this.balance = balance;
		this.userId = userId;
	}
	
	public AccountDTO(String accNum, String accHolder, double balance, String userId) {
		this.accNum = accNum;
		this.accHolder = accHolder;
		this.balance = balance;
		this.userId = userId;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
