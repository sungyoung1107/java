package cal;

public class Cal {
	
	public static double div(int a, int b) throws Exception {
		double result = 0.0;
		try {
			result = a / b;
		}catch(Exception e) {
//			System.out.println("잘못 입력 하셨습니다."); // 의미 없음..... 화면에 출력이 안됨......
			throw e; //  Exception을 던질거다.
		}
		return result;
	}
	
	public static double div(double a, double b) throws InfinityException { /* Exception도 가능 */
		double result = 0.0;
		
		if(b == 0.0) {
			// 우리가 만든 예외를 화면에서 던진다. 이경우는 밑에 result = a / b 실행 안됨
			throw new InfinityException("B00001");
		}
		
		result = a / b;

		return result;
	}
	
}
