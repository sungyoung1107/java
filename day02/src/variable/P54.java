package variable;

public class P54 {

	public static void main(String[] args) {
		// boolean
		boolean b1= true;
		boolean b2 = 10 > 5;
		boolean b3 = 10 < 5;
		System.out.println("b1은 "+ b1 + " b2는 "+ b2 +" b3는 "+ b3);
		
		// 정수
		int n1 = 10;
//		long n2 = 200000000000; // 자바에서는 기본은 int다.
		long n2 = 200000000000L; // 그래서 오른쪽이 int가 아닌 long이라는 것을 표시해주기 위해 L을 붙인다.
		
		// 실수
		double d1 = 1.0;
//		float f1 = 1.0; // 자바에서 기본은 double이다. double에서 float로 낮은 자료형으로는 변환 불가하다.
		float f1 = 1.0F;
		
		double d2 = 1/2; // 1과 2가 정수이고, 1/2가 정수가 되어서 0으로 됨
		System.out.println(d2);
		double d3 = 10.0/3.0; // 1과 2가 정수이고, 1/2가 정수가 되어서 0으로 됨
		System.out.println(d3);
		
//		float f2 = 10.0/3.0; // 자바에서 기본은 double이다. double에서 float로 낮은 자료형으로는 변환 불가하다.
		float f2 = 10.0f/3.0f;
		System.out.println(f2);
		
		// char (문자 1개)
		char c1 = 'A';
		System.out.println(c1);
		
		char c2 = 65;
		System.out.println(c2);
		
		int n3 = 10;
		double n4 = 10.0;
//		int result = n3 + n4 ;
		double result = n3 + n4 ; // 변수를 써라..
				


	}

}
