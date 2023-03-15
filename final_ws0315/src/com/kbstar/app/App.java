//package com.kbstar.app;
//
//
//import java.util.Scanner;
//
//public class App {
//	
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		APP_Receiving ar = new APP_Receiving(); //수신계좌 화면 객체 생성
//		APP_Loan al = new APP_Loan(); //여신계좌 화면 객체 생성
//		String menu; // 메뉴를 담는 변수
//		
//		// INTRO //
//		System.out.println("== 안녕하십니까 고객님, KB국민은행에 오신 것을 환영합니다! ==");
//		
//		// MENU : < 1.입출금/적금계좌, 2.대출계좌, 3.나가기 > //
//		while(true) {
//			System.out.println("== 거래하실 메뉴를 번호로 입력해주세요 == ");
//			System.out.println("< 1.입출금/적금계좌, 2.대출계좌, 3.나가기 >");
//			menu = sc.next(); // 첫번째 메뉴를 입력받는다.
//			
//			try {
//				if(Integer.parseInt(menu)==3) {
//					System.out.println("== 고객님 KB국민은행을 거래해주셔서 감사합니다 == ");
//					break;
//				}else if(Integer.parseInt(menu)==1) {
//					// 수신계좌 화면 호출						
//					ar.app_r();
//				}else if(Integer.parseInt(menu)==2) {
//					// 여신계좌 화면 호출
//					al.app_l();
//				}else {
//					System.out.println("[다시 거래해주세요] 고객님 메뉴 번호를 다시 확인하시고 거래하시기 바랍니다. ");
//				}
//			}catch(NumberFormatException e) {
//				System.out.println("[다시 거래해주세요] 고객님 메뉴 번호를 다시 확인하시고 거래하시기 바랍니다. ");
//			}
//		}
//		
//		sc.close();
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
