package variable;

public class P69 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdef";
		str = str.toUpperCase();
		System.out.println(str);
		
		String str2 = str.replace('A', 'd'); // 주소. --> 값을 이야기 함 // 값이 바뀌는 것이 아니라 바뀐 값을 가르키는 주소를 새로 만들어 가르키게 됨
		System.out.println(str2);
		
		int lng = str.length();
		System.out.println(lng);
		
		int t = str.indexOf('B');
		System.out.println(t);
		
		char c = str.charAt(0);
		System.out.println(c);
		
		String str3 = str.substring(1, 3);
		System.out.println(str3);
		
		String email = "jmlee@tonesol.com";
		
//		String id = email.substring(0,5);
//		String domain = email.substring(6,17);
//		
//		System.out.printf("%s, %s\n", id, domain);
		
		int specific = email.indexOf('@');
		
		String id1 = email.substring(0,specific);
		String domain1 = email.substring(specific+1, email.length());
		
		System.out.printf("%s, %s", id1, domain1);
		
	}

}
