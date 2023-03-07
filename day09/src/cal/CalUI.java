package cal;

import java.util.Scanner;

public class CalUI {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int a;
		int b;
		
		System.out.println("Input 2 Number ");
		a = Integer.parseInt(sc.next());
		b = Integer.parseInt(sc.next());
		
		double result =0.0;
		
			try {
				result = Cal.div(a, b);
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		System.out.println(result);
//		System.out.println()
		
		sc.close();
	}

}
