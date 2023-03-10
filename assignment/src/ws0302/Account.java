package ws0302;

public class Account {
	
	private String accNum; //계좌번호(임의생성)
	private String accName; //사용자이름
	private double balance; //잔액
	private double rate; //이자율
	private String grade; //고객등급
	
	public Account() {
		this.accNum = MakeAccountNumber.makeAccNum();
	}
	
	public Account(String accName, double balance, double rate, String grade) {
		this();
		this.accName = accName;
		this.balance = balance;
		this.rate = rate;
		this.grade = grade;
	}
	
	public Account(String accNum, String accName, double balance) {
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
			System.out.println("잔액이 부족합니다. 필요하시면 마이너스 통장을 개설해보세요! ");
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

	// 이자금액 계산	
	public double getInterest() {
		return (balance*rate)*(84.6/100); /* 이자소득세(15.4%) 제외 */
	}
	
	// 계좌번호 반환 메소드
	public String getAccNum() {
		return accNum;
	}
	
	// 사용자 이름 반환 메소드
	public String getAccName() {
		return accName;
	}
	
	// 잔액 반환 메소드
	public double getBalance() {
		return balance;
	}
	
	// 이자율 반환 메소드
	public double getRate() {
		return rate;
	}
	
	// 고객등급 반환 메소드
	public String getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", accName=" + accName + ", balance=" + balance + ", rate=" + rate
				+ ", grade=" + grade + "]";
	}


}
