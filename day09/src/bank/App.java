package bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {	
		
		Account acc = null;
		String menu ; // 메뉴
		String name; // 계좌이름
		String accHolder; // 예금주
		double balance; // 잔액
		double money; // 입금금액
		
		Scanner sc = new Scanner(System.in);
		
		// INTRO //
		System.out.println("== 안녕하십니까 고객님, KB국민은행에 오신 것을 환영합니다! ==");
		
		// MENU : < 1. 계좌 생성, 2. 계좌 정보 조회, 3. 계좌 입금, 4. 계좌 출금, 5. 나가기 > //
		while(true) {
			System.out.println("== 거래하실 메뉴를 번호로 입력해주세요 == ");
			System.out.println("< 1.계좌 생성, 2.계좌 정보 조회, 3.계좌 입금, 4.계좌 출금, 5.나가기 >");
			menu = sc.next(); // 첫번째 메뉴를 입력받는다.
			
			try {
				if(Integer.parseInt(menu)==5) {
					System.out.println("== 고객님 KB국민은행을 거래해주셔서 감사합니다 == ");
					break;
				}else if(Integer.parseInt(menu)==1) { // 계좌 생성
					System.out.println("== 계좌를 신규하겠습니다 ==");
					
					// 이름
					System.out.println("== 이름을 입력해주세요 ==");
					accHolder = sc.next();
					
					// 계좌 종류
					System.out.println("== 계좌종류를 입력해주세요 ==");
					System.out.println("== 보통예금, 저축예금 둘 중 1개로 입력해주세요 ==");
					name = sc.next();
					
					// 최초 입금금액 (숫자 입력 될 때까지 받음)
					while (true) {
						try {
							System.out.println("== 계좌에 최초로 넣으실 금액을 입력해주세요. 0원 이상 넣으셔야 합니다 ==");
							balance = sc.nextDouble();
							break;
						} catch (InputMismatchException e1) {
							System.out.println("[다시 거래해주세요] 숫자로 입력하시기 바랍니다. ");
							sc.next(); // 커서 처리 
						} 
					}
					
					try {
						acc = new Account(name, accHolder, balance);
					} catch (UserException e2) {
						System.out.println(e2.getMessage());
					}
					
				}else if(Integer.parseInt(menu)==2) { // 계좌 정보 조회
					
					if (acc == null) {
						System.out.println("== 계좌 신규를 먼저 진행해주세요 ==");
					}else {	
						System.out.println("== 계좌를 조회합니다 ==");
						System.out.println(acc.toString());		
					}
					
				}else if(Integer.parseInt(menu)==3) { // 계좌 입금
					
					if (acc == null) {
						System.out.println("== 계좌 신규를 먼저 진행해주세요 ==");
					}else {	
						// 입금금액 (숫자 입력 될 때까지 받음)
						while (true) {
							try {
								System.out.println("== 입금하실 금액을 입력해주세요 ==");
								money = sc.nextDouble();
								acc.deposit(money);
								break;
							} catch (InputMismatchException e1) {
								System.out.println("[다시 거래해주세요] 숫자로 입력하시기 바랍니다. ");
								sc.next(); // 커서 처리 
							} catch (UserException e2) {
								System.out.println(e2.getMessage());
							}
						}
					}
					
				}else if(Integer.parseInt(menu)==4) { // 계좌 출금
					
					if (acc == null) {
						System.out.println("== 계좌 신규를 먼저 진행해주세요 ==");
					}else {
						// 출금금액 (숫자 입력 될 때까지 받음)
						while (true) {
							try {
								System.out.println("== 출금하실 금액을 입력해주세요 ==");
								money = sc.nextDouble();
								acc.withdraw(money);
								break;
							} catch (InputMismatchException e1) {
								System.out.println("[다시 거래해주세요] 숫자로 입력하시기 바랍니다. ");
								sc.next(); // 커서 처리 
							} catch (UserException e2) {
								System.out.println(e2.getMessage());
							}
						}
					}
					
				}else {
					System.out.println("[다시 거래해주세요] 고객님 메뉴 번호를 다시 확인하시고 거래하시기 바랍니다. ");
				}
			} catch(NumberFormatException e) {
				System.out.println("[다시 거래해주세요] 고객님 메뉴 번호를 다시 확인하시고 거래하시기 바랍니다. ");
			} 
		}
	
	sc.close();
		
	}

}
