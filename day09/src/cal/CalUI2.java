package cal;

import java.util.Scanner;

public class CalUI2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input 2 Number ");
		double a = Integer.parseInt(sc.next());
		double b = Integer.parseInt(sc.next());
		double result =0.0;
		
		try {
			result= Cal.div(a, b);
		} catch (InfinityException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println(result);
		
		sc.close();
	}

}
