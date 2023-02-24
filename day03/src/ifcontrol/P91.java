package ifcontrol;

public class P91 {

	public static void main(String[] args) {
		int a = 100;
		int b = 20;
		int c = -15;
		int min = 0;
		int max = 0;

		// 세가지 수의 최대 값과 최소 값을 구하시오
		/* if문으로 */
//		if ((a > b) && (a > c)) {
//			max = a;
//		}else if ((b > a) && (b > c)) {
//			max = b;
//		}else { 
//			max = c;
//		}
//		
//		if ((a < b) && (a < c)) {
//			min = a;
//		}else if ((b < a) && (b < c)) {
//			min = b;
//		}else { 
//			min = c;
//		}
		
		max = (a > b) && (a > c) ? a : (b > a) && (b > c) ? b : c ;
		min = (a < b) && (c < c) ? a : (b < a) && (b < c) ? b : c ;
		
		System.out.println("최대값은 : " + max);
		System.out.println("최소값은 : " + min);
		System.out.printf("MAX : %d, MIN : %d\n", max, min);
		
		/* 배열 계산 */
		int arr[] = {a, b, c};
		min = arr[0];
		max = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			if(min > arr[i])
				min = arr[i];
			if(max < arr[i])
				max = arr[i];
		}
		
		System.out.println("최대값은 : " + max);
		System.out.println("최소값은 : " + min);
		System.out.printf("MAX : %d, MIN : %d\n", max, min);
		
		if(a > b) { // a가 b보다 클 때 : b < a
			max = a;
			min = b;
			if (a < c) {
				max = c;
			}else {
				if (b > c) {
					min = c;
				}
			}
		}else { // a가 b보다 작을 때 : a < b
			min = b;
			max = a;
			if (b < c) {
				max = c;
			}else {
				if (a < c) {
					min = a;
				}
			}
		}
		
		System.out.println("최대값은 : " + max);
		System.out.println("최소값은 : " + min);
		System.out.printf("MAX : %d, MIN : %d\n", max, min);
		
		min = 0;
		max = 0;
		
		if (a > b) {
			max = Math.max(a, c);
			min = Math.min(b, c);
		}else { // b < a
			max = Math.max(b, c);
			min = Math.min(a, c);
		}
		
		
		System.out.println("최대값은 : " + max);
		System.out.println("최소값은 : " + min);
		System.out.printf("MAX : %d, MIN : %d\n", max, min);
		
	}

}
