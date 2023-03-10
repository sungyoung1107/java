package com.kbstar.dto;

public class TransactionDTO {
	
	private String date;
	private String accNo;
	private double balance;
	private String type; // I / O
	private String desc;
	private String bank;
	
	
	public TransactionDTO() {
	}


	public TransactionDTO(String date, String accNo, double balance, String type, String desc, String bank) {
		this.date = date;
		this.accNo = accNo;
		this.balance = balance;
		this.type = type;
		this.desc = desc;
		this.bank = bank;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getAccNo() {
		return accNo;
	}


	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransactionDTO [date=").append(date).append(", accNo=").append(accNo).append(", balance=")
				.append(balance).append(", type=").append(type).append(", desc=").append(desc).append(", bank=")
				.append(bank).append("]");
		return builder.toString();
	}
	
	

}
