package ifcontrol;

public class ws {

	public static void main(String[] args) {
		
		int sum_3 = 0;
		int count_3 = 0;
		double avg_3 = 0.0;
		int sum_4 = 0;
		int count_4 = 0;
		double avg_4 = 0.0;
		int sum_7 = 0;
		int count_7 = 0;
		double avg_7 = 0.0;
		
		for (int i=1; i<=100 ; i++) {
			if(i%3 == 0) {
				// 3의 배수이면
				sum_3+=i;
				count_3++;
			}
			if(i%4 == 0) {
				// 4의 배수이면
				sum_4+=i;
				count_4++;
			}
			if(i%7 == 0) {
				// 7의 배수이면
				sum_7+=i;
				count_7++;
			}
		}
		
		avg_3 = sum_3 / (count_3*1.0);
		avg_4 = sum_4 / (count_4*1.0);
		avg_7 = sum_7 / (count_7*1.0);
		
		System.out.println("3의 배수의 합은 "+ sum_3 + " 평균은 "+ avg_3);
		System.out.println("4의 배수의 합은 "+ sum_4 + " 평균은 "+ avg_4);
		System.out.println("7의 배수의 합은 "+ sum_7 + " 평균은 "+ avg_7);

	}

}
