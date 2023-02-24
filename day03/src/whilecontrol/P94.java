package whilecontrol;

public class P94 {

	public static void main(String[] args) {
		// 합과 평균을 구하시오
		// 짝수만 구하시오
		int sum = 0;
		double avg = 0.0;
		
		System.out.println("Start ...");
		int cnt = 0;
		for(int i=1; i<=10 ; i++) {
			
			if(i%2 == 0) {
				sum+=i;
				cnt++;
			}
			
			if(i==8) {
				break; //for문 그만 돌려라
			}
			
//			if(i%2 != 0) {
//				continue;
//			}
//			sum+=i;
//			cnt++;
		}
		avg = sum /(cnt*1.0);
		System.out.println("합은 "+sum + " 평균은 "+ avg);
		System.out.println("End ...");

	}

}
