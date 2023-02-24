package whilecontrol;

public class P93 {
	
	public static void main(String[] args) {
		
		System.out.println("Start ...");
		int i = 1;
		int sum = 0;
		double avg = 0;
		
		while(i <= 100) {
			sum+=i;
			i++;
		}
		
		i--;
		
		avg = sum / (i*1.0);
		System.out.println("합계는" + sum + " 평균은 " + avg);
		System.out.println("End ...");

	}

}
