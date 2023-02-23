package variable;

import java.util.Random;
import java.util.Scanner;

public class P75 {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
//		a++;
//		++b;
		System.out.printf("%d,%d \n", a, b);
		
		int result = ++a + b++;
		System.out.printf("%d,%d \n", a, b);
		System.out.println(result);
		
		System.out.println(5==5);
		
		int aa = 10;
		int bb = 10;
		
//		System.out.println( (aa++>=0) || (bb++>=0) ); // 조건이 앞쪽에서 만족하면 뒤에 연산 안함 (보통 b 값 무조건 증가 시켜줘야 하면 |로..)
//		System.out.printf("%d, %d\n", aa, bb);
		
		System.out.println( (aa++>=0) | (bb++>=0) ); // 조건이 앞쪽에서 만족해도 뒤에 연산함
		System.out.printf("%d, %d\n", aa, bb);
	}

}
