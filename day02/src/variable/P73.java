package variable;

import java.util.Scanner;

public class P73 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		String str ="";
		Scanner sc = new Scanner(System.in);
		System.out.println("명령어를 입력 하시오(q, i, d, s)");
		String cmd = sc.next();
		System.out.printf("%s를 입력했습니다.", cmd);
		sc.close();
	}

}
