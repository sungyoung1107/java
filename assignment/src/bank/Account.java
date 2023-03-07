package bank;

import java.util.Random;

public class Account {
	
	private String accNo; // 계좌번호
	private String name; // 계좌이름
	private String accHolder; // 예금주
	private double balance; // 잔액

	public Account() {
		this.accNo =  makeAccNum();
	}
	
	// constructor - 음수 예외 상황
	public Account(String name, String accHolder, double balance) throws UserException {
		this();
		this.name = name;
		this.accHolder = accHolder;
		if (balance < 0) {
			throw new UserException("계좌 최초 신규시 음수값은 입력 불가합니다.");
		}else {
			this.balance = balance;	
		}
	}
	
	// 계좌정보조회
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accNo=").append(accNo).append(", name=").append(name).append(", accHolder=")
				.append(accHolder).append(", balance=").append(balance).append("]");
		return builder.toString();
	}

	// 잔액 조회
	public void getBalance() {
		
		System.out.printf("잔액은 %.0f원입니다.", balance);
		
	}
	
	// 입금 - 음수 예외 상황
	public void deposit(double money) throws UserException{
		
		if(money < 0) {
			throw new UserException("입금금액을 확인하시기 바랍니다. 확인 후 다시 거래 하시기 바랍니다.");
		}
		
		balance+=money; // 예외처리가 아닌 경우 실행
	}
	
	// 출금 - 잔액 부족 예외 사항, 음수 예외 사항
	public void withdraw(double money) throws UserException{
		
		if(money > balance) {
			throw new UserException("출금한도를 초과했습니다. 확인 후 다시 거래 하시기 바랍니다.");
		}else if (money < 0) {
			throw new UserException("출금금액을 확인하시기 바랍니다. 확인 후 다시 거래 하시기 바랍니다.");
		}

		balance-=money; // 예외처리가 아닌 경우 실행
	}
	
	public String makeAccNum() {
		
		Random rd = new Random();
		
		String accNo = "";
			accNo = String.format("%04d", rd.nextInt(10000)) + 
					"02" + "-" + "01" + "-" + String.format("%06d", rd.nextInt(1000000)); 
			return accNo;
	}
}
