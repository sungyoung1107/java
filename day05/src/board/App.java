package board;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Service service = new Service();
		
		while(true) {
			System.out.println("Input cmd(r, u, d, g, q)");
			String cmd = sc.next();
			
			if(cmd.equals("q")) {
				System.out.println("Bye. ");
				break; // return 은 함수 안에서 특정 예외사항이 발생할 때 쓰는 것이다.
			}else if (cmd.equals("r")) {
				System.out.println("Input contents");
				String content = sc.next();
				service.register(content);
			}else if (cmd.equals("u")) {
				System.out.println("Input number of content");
				int num = Integer.parseInt(sc.next());
				System.out.println("Input contents");
				String contents = sc.next();
				service.modify(num, contents);
			}
			else if (cmd.equals("d")) {
				System.out.println("Input number of content");
				int num = Integer.parseInt(sc.next());
				service.remove(num);
			}else if (cmd.equals("g")) {
				System.out.println("Input number");
				int num = sc.nextInt();
				String result = service.get(num);
				System.out.println(result);
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		
		sc.close();
		

	}

}
