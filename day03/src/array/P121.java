package array;

import java.util.Scanner;

public class P121 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("Input command[q, i, s]");
			String cmd = sc.next();
			
			if(cmd.equals("q")) {
				System.out.println("Quit..");
				break;
			}else if(cmd.equals("i")){
				System.out.println("Insert..");
				System.out.println("Input ID...");
				String id = sc.next();
				System.out.println("Input PWD...");
				String pwd = sc.next();
				System.out.println("Input NAME...");
				String name = sc.next();
				System.out.printf("%s, %s, %s Inserted..\n", id, pwd, name);
			}else if(cmd.equals("s")) {
				System.out.println("Select..");
			}
			else {
				System.out.println("Invalid Command..");
				System.out.println("Try Again..");
			}
		} //end while
		
		System.out.println("Bye...");
		sc.close();

	}

}
