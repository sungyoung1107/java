package bank;

import java.util.Scanner;

public class App2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account acc = null; 
		System.out.println("KB국민은행에 오신 것을 환영합니다!");
		while(true) {
			System.out.println("Input Command(c(계좌신규), w(출금), d(입금), s(계좌조회), q(종료)): ");
			String cmd = sc.next();
			if (cmd.equals("q")) {
				System.out.println("Bye...");
				break;
			}else if (cmd.equals("c")) {
				System.out.println("Create Account ");
				System.out.println("계좌 정보를 입력하세요[name,balance]");
				System.out.println("Input Name: ");
				String name = sc.next();
				System.out.println("Input Balance: ");
				double balance = Double.parseDouble(sc.next());
				acc = new Account(name, balance);
				System.out.println(acc);
			}else if (cmd.equals("w")) {
				System.out.println("Widthdraw ");
				System.out.println("출금하실 금액을 입력해주세요: ");
				double money = sc.nextDouble();
//				double money = Double.parseDouble(sc.next());
				acc.withdraw(money);			
			}else if (cmd.equals("d")) {
				System.out.println("Deposit ");
				System.out.println("입금하실 금액을 입력해주세요: ");
				double money = sc.nextDouble();
//				double money = Double.parseDouble(sc.next());
				acc.deposit(money);
			}else if (cmd.equals("s")){
				System.out.println("Select ");
				System.out.println(acc);
			}	
			else {
				System.out.println("고객님, 잘못 입력하셨습니다!");
			}
		
		}
		sc.close();
	}

}
