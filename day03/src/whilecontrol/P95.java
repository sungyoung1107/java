package whilecontrol;

public class P95 {

public static void main(String[] args) {
		
		System.out.println("Start ...");
		int i = 1;
		int sum = 0;
		double avg = 0;
		int count = 0;
		
		while(i <= 10) {
			if(i%2==0) {
				sum+=i;
				count++;
			}

			if(i==8) {
				break;
			}
			i++;
		}
		
		avg = sum / (count*1.0);
		System.out.println("합계는" + sum + " 평균은 " + avg);
		System.out.println("End ...");

	}

}
