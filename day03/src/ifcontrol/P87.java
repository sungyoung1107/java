package ifcontrol;

public class P87 {

	public static void main(String[] args) {
		String grade = "VIP";
		String gender = "M";
		double sum = 100;
		System.out.println("Start....");
		
		if (sum<=100 && sum>=90) {
			grade ="VIP";
		}
		else if (sum<=89 && sum>=80) {
			grade ="GOLD";
		}
		else if (sum<=79 && sum>=70) {
			grade ="SILVER";
		}
		else if (sum<=69 && sum>=60) {
			grade ="BRONZE";
		}
		else if (sum<=59) {
			grade = "NORMAL";
		}
		else System.out.println("100 초과");
		
		
		if(grade.equals("VIP")) {
			System.out.println("VIP 혜택....");
//			return; /* 흐름이 아예 종료 (main도 안함) */
		}
		
		if(gender.equals("M")) {
			System.out.println("Male....");
		}else {
			System.out.println("Female....");
		}
		
		
		grade = sum >= 90.0 ? "VIP" : (sum>=70.0 ? "GOLD" : "SILVER");
		
		System.out.printf("%s, %s, %f\n", grade, gender, sum);
		System.out.println("End.....");

	}

}
