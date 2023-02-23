package variable;

public class P78 {

	public static void main(String[] args) {
		int a = 10;
		a = a + 1; /* a--와 a-1는 같음 */
		System.out.println(a);
		
		int b = 20;
		b += 1; // 위에보다 빠름
		b = b + 1; // 위에보다 느림
	}

}
