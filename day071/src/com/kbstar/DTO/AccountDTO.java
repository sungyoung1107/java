package com.kbstar.DTO;

public class AccountDTO {
	
	private String accNum;
	private String accName;
	private double balance;
	private double interest;
	
	public AccountDTO() {

	}

	public AccountDTO(String accNum, String accName, double balance) {
		this.accNum = accNum;
		this.accName = accName;
		this.balance = balance;
	}
	
	// 출금
	public void withdraw(double money) {
		
		if(money<=0) {
			System.out.println("출금 금액을 확인하세요. ");
			return;
		}
		if(this.balance < money ) {
			System.out.println("잔액이 부족합니다. ");
			return;
		}
		this.balance-=money;
	}
	
	// 입금
	public void deposit(double money) {
		
		if(money<=0) {
			System.out.println("입금 금액을 확인하세요. ");
			return;
		}
		this.balance+=money;
	}
	
	public double interestCal() {
		return (balance*interest/100)*(84.6/100); /* 15.4% 이자 제외 */
	}
	
	// 잔액 조회
	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", accName=" + accName + ", balance=" + balance + ", interest=" + interest + "]";
	}
	

}
