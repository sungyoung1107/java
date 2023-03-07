package p214;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		
		int num = 0;
		
		try(Scanner sc = new Scanner(System.in)) {	// try 안에서 scanner를 사용해도 자동으로 종료(close 필요 없음)
			System.out.println("Input num...");
			num = Integer.parseInt(sc.next());
			int result = 10 / num;
			System.out.println(result);
		}catch(Exception e){
			System.out.println("잘못 입력 하셨습니다.");
		}
		
		System.out.println("END APPLICATION");

	}

}
