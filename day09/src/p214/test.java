package p214;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input num...");
//		
//		try {	
//			int num = Integer.parseInt(sc.next());
//			int result = 10 / num;
//			System.out.println(result);
//		}catch(ArithmeticException  e1){
//			System.out.println("분모가 0입니다.");
//			e1.printStackTrace();
//		}catch(NumberFormatException e2) {
//			System.out.println("숫자를 입력하세요. ");
//			e2.printStackTrace();
//		}finally {
//		System.out.println("반드시 실행");
//		sc.close();
//	}
		
		try {	
			int num = Integer.parseInt(sc.next());
			int result = 10 / num;
			System.out.println(result);
		}catch(ArithmeticException  | NumberFormatException e2){
			System.out.println("잘못 입력 하셨습니다.");
		}finally {
			System.out.println("반드시 실행");
			sc.close();
		}
		
		sc.close();
		
		System.out.println("END APPLICATION");

	}

}
