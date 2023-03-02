package overLoading;

public class Calculator {
	
	// 오버로딩은 동일한 메소드 이름으로 되어 있어야 하며 매개변수 타입이 달라야 한다. 매개변수의 명칭은 중요하지 않다.
	// 오버로딩은 리턴값만 다른건 불가하다.
	
	public int sum2(int a, double b) {
		int result = 0;
		result = a + (int) b;
		return result;
	}
	
	public int sum3(int a, int b, int c) {
		int result = 0;
		result = a + b + c;
		return result;
	}
	
	public int sum3(int a, int b, int c, int d) {
		int result = 0;
		result = a + b + c + d;
		return result;
	}
}
