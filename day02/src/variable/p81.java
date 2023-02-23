package variable;

import java.util.Scanner;

public class p81 {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Input Number.. ");
			int a = Integer.parseInt(sc.next());
			String result="";
			result = a > 0 ? "정상" : "비정상" ;
			System.out.println(result);
			sc.close();
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
