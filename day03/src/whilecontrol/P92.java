package whilecontrol;

public class P92 {

	public static void main(String[] args) {
		// 합과 평균을 구하시오
		System.out.println("Start ...");
		int sum = 0;
		int cnt = 0;
		double avg = 0.0;
		for(int i=1; i<=100 ; i++) {
			sum+=i;
			cnt++;
		}
		avg = sum/ (cnt*1.0);
		System.out.println("합은 "+sum + " 평균은 "+ avg);
		System.out.println("End ...");

	}

}
