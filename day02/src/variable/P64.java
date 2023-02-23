package variable;

public class P64 {
	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		double d = 10.2;
		String str1 = "abc";
		str1 = "def";
		String str2 = "abc";
		System.out.printf("%d %4.2f %s \n", a, d, str1);
		System.out.println(str1); // def를 힙에 할당하고, 스택은 새로운 번지를 만들어 새로 가르킨다.
		System.out.println(str2);
		
		
		if(str1 == str2) { // 스택 메모리를 비교
			System.out.println("OK");
		} else {
			System.out.println("NO");
		}
		
		if(str1.equals(str2)) { // 문자열이 같은지 비교
			System.out.println("OK");
		} else {
			System.out.println("NO");
		}
		
		String str3 = new String("abc");
		str3 = "def";
		String str4 = new String("abc");
		System.out.println(str3); // def를 힙에 할당하고, 스택은 새로운 번지를 만들어 새로 가르킨다.
		System.out.println(str4);
		
		if(str3 == str4) { // 스택 메모리를 비교
			System.out.println("OK");
		} else {
			System.out.println("NO");
		}
		
		if(str3.equals(str4)) { // 문자열이 같은지 비교
			System.out.println("OK");
		} else {
			System.out.println("NO");
		}
		
	}
}
