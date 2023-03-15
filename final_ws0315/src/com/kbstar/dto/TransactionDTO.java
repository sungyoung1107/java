package com.kbstar.dto;


public class TransactionDTO {
	
	private String transdate;
	private String accNum;
	private double money;
	private String type; // in / out
	private String rAcc; // 받는 계좌

	public TransactionDTO() {
	}
	
	public TransactionDTO(double money, String type) {
		this.money = money;
		this.type = type;
	}
	
	public TransactionDTO(String transdate, String accNum, double money, String type, String rAcc) {
		this.transdate = transdate;
		this.accNum = accNum;
		this.money = money;
		this.type = type;
		this.rAcc = rAcc;
	}

	//컨스트럭터 설명 : 아래 4개 입력하면 (계좌이체일시)는 자동생성.
	public TransactionDTO(String accNum, double money, String type, String rAcc) {
		this.accNum = accNum;
		this.money = money;
		this.type = type;
		this.rAcc = rAcc;
	}

	public String getTransdate() {
		return transdate;
	}

	public void setTransdate(String transdate) {
		this.transdate = transdate;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getrAcc() {
		return rAcc;
	}

	public void setrAcc(String rAcc) {
		this.rAcc = rAcc;
	}
	//출력정보
	@Override
	public String toString() {
		return "TransactionDTO [transdate=" + transdate + ", accNum=" + accNum + ", money=" + money + ", type=" + type
				+ ", rAcc=" + rAcc + "]";
	}

}
