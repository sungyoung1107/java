package variable;

import java.util.Random;

public class P68 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "10";
		int s2 = Integer.parseInt(s1); // 자바 api (String - > int)
		int a = 10;
		System.out.println(s1 + a); // 문자열 + int는 문자열
		System.out.println(s2 + a); // 문자열 + int는 문자열

		int n1 = 10;
		String n2 = String.valueOf(n1); // 자바 api (int -> String)

		Random rd = new Random();
		
		int rndNum = rd.nextInt(45)+1; /* 0~44까지 랜덤 함수 중 1을 더하면 1~45까지 */
		System.out.println(rndNum);
	}

}
