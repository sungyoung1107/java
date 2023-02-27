package variable;
import java.util.Scanner;

public class email {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이메일을 입력하세요 : ");
		String email = sc.next();
		
		int specific = email.indexOf('@'); /* @ index 추출 */
		System.out.print("이메일의 @ 인덱스는 : ");
		System.out.println(specific);
		System.out.print("이메일의 길이는 : ");
		System.out.println(email.length());
		
		String id = email.substring(0,specific);
		
		String domain = email.substring(specific+1, email.length());
		
		System.out.printf("이메일 아이디는 : %s, 이메일 도메인은: %s", id, domain);
	}
	

}
