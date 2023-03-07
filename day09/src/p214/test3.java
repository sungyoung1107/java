package p214;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		
		double a = 0;
		double result = 10 / a ;
		
		System.out.println(result);
		
		try {
			Thread.sleep(2000); // 2초 후에 실행
		} catch (InterruptedException e) { // 강제로 종료
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InputStreamReader ir = new InputStreamReader(System.in);
		System.out.println("Input Character...");
		int b = 0;
		try {
			b = ir.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b);
		System.out.println("END APPLICATION");
		
		
	}

}
