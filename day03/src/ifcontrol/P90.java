package ifcontrol;

public class P90 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = 15;
		// 두가지 수의 최대 값과 최소 값을 구하시오
		int min = 0 ;
		int max = 0;

		// a와 b 비교
		if (a > b) {
			max = a;
			min = b;
		}else {
			max = b;
			min = a;
		}
		
		min = 0;
		max = 0;
		
		
		System.out.println("최대값은 : " + max);
		System.out.println("최소값은 : " + min);
		System.out.printf("MAX : %d, MIN : %d", max, min);
	}

}
