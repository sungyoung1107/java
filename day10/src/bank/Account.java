package bank;

public class Account {
	
	private String accNo; // 계좌번호
	private double balance; // 잔액
	
	public Account(){
		this.accNo = MakeAccountNumber.makeAccNum();
	}
	
	public Account(double balance) throws Exception {
		this();
		if(balance < 0) {
			throw new Exception("ER0001");
		}
		this.balance = balance;
	}
	
	public Account(String accNo, double balance) throws Exception {
		this.accNo = accNo;
		if(balance < 0) {
			throw new Exception("ER0001");
		}
		this.balance = balance;
	}
	
	public void widthdraw(double money) throws Exception {
		
		if(money <= 0) {
			throw new Exception("EX0002");
		}
		if(balance < money) {
			throw new Exception("EX0003");
		}
		balance -= money;
	}
	
	public void deposit(double money) {
		balance += money;
	}
	
}
