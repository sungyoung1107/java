package ifcontrol;

public class P88 {

	public static void main(String[] args) {
		String grade = "VIP";
		String gender = "M";
		double sum = 100;
		System.out.println("Start....");
		
		if ((sum<=100 && sum>=95) || (sum<=90 && sum>=85)) {
			grade ="VIP";
		}
		else if ((sum<=80 && sum>=75) || (sum<=65 && sum>=60)) {
			grade ="GOLD";
		}
		else grade ="NORMAL";
		
		
		if(grade.equals("VIP")) {
			System.out.println("VIP 혜택....");
//			return; /* 흐름이 아예 종료 (main도 안함) */
		}
		
		if(gender.equals("M")) {
			System.out.println("Male....");
		}else {
			System.out.println("Female....");
		}
		
		System.out.printf("%s, %s, %f\n", grade, gender, sum);
		System.out.println("End.....");

	}

}
