package com.kbstar.app;

import java.util.List;
import java.util.Scanner;

import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.BankService;
import com.kbstar.service.BankServiceImpl;

public class App {

	public static void main(String[] args) {
		BankService<UserDTO, AccountDTO, TransactionDTO, String, String>
		service = new BankServiceImpl(); // bank서비스
		UserDTO user ; // user정보
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Register(r) or Login(l) / 나가기(q) ");
			String cmd = sc.next();
			if(cmd.equals("q")) {
				break;
			}else if(cmd.equals("r")) {
				System.out.println("Register.. ");
				String id = sc.next();
				String pwd = sc.next();
				String name = sc.next();
				String email = sc.next();
				String contact = sc.next();
				user = new UserDTO(id, pwd, name, email, contact); // 사용자 정보를 만든다.
				try {
					service.register(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					continue;
				}
				System.out.println("환영합니다");
			}else if(cmd.equals("l")) {
				System.out.println("Login.. ");
				String id = sc.next();
				String pwd = sc.next();
				try {
					 user = service.login(id, pwd);
					 System.out.println(user);
					 System.out.println("로그인 성공");
					 System.out.println("-------------------------");
					 while(true) {
						 System.out.println("Menu(m: 계좌개설, t: 계좌이체, a: 계좌조회, i: 사용자정보조회, tr: 거래내역보기, e: 나가기)");
						 String menu = sc.next();
						 if(menu.equals("e")) {
							 break;
						 }else if (menu.equals("m")) {
							 System.out.println("Make Account");
							 System.out.println("금액을 입력해주세요");
							 double balance = Double.parseDouble(sc.next());
							 service.makeAccount(user.getId(), balance);
							 System.out.println("계좌 생성 완료");
						 }else if (menu.equals("t")) {
							 System.out.println("Transation");
							 System.out.println("이체할 금액을 입력해주세요");
							 double balance = Double.parseDouble(sc.next());
							 System.out.println("나의 계좌번호를 입력해주세요");
							 String sendAcc = sc.next();
							 System.out.println("상대방 계좌번호를 입력해주세요");
							 String receiveAcc = sc.next();
							 System.out.println("적요를 입력해주세요");
							 String desc = sc.next();
							 service.transaction(sendAcc, receiveAcc, balance, desc);
							 System.out.println("계좌이체 완료");
						 }else if (menu.equals("a")) {
							 System.out.println("Select Account");
							 List<AccountDTO> list = null;
							 list = service.getAllAccount(user.getId()); 
							 for(AccountDTO acc : list) {
								 System.out.println(acc);
							 }
						 }else if (menu.equals("i")) {
							 System.out.println("User Info");
							 String rid = user.getId();
							 UserDTO ruser = null;
							 ruser = service.getUserInfo(rid);
							 System.out.println(ruser);
						 }else if (menu.equals("tr")) {
							 System.out.println("Select Transaction");
							 String accNo = sc.next();
							 List<TransactionDTO> list = null;
							 list = service.getAllTr(accNo);
							 for (TransactionDTO trans : list) {
								 System.out.println(trans);
							 }
						 }
						 
					 }
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
		}
		sc.close();

	}

}
