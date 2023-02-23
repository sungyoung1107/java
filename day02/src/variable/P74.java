package variable;

import java.util.Random;
import java.util.Scanner;

public class P74 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		// next()로 받아서 Integer.parseInt(변수)로 넣고 해줘도 됨 
		
		while(true) {
		
			System.out.println("10~100 사이의 정수를 입력하세요 : ");
			int num = sc.nextInt();
			
			if(num < 10 || num > 100) {
				System.out.println("10~100 사이의 정수를 입력하세요 : ");
				num = sc.nextInt();
			}else {
				System.out.println(rd.nextInt(num)+1);
				break;
			}
		
		}
		sc.close();
	}

}
