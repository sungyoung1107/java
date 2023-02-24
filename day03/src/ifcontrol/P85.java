package ifcontrol;

public class P85 {

	public static void main(String[] args) {
		String grade = "VIP";
		String gender = "M";
		double sum = 100;
		System.out.println("Start....");
		if(grade.equals("VIP")) {
			System.out.println("VIP 혜택....");
//			return; /* 흐름이 아예 종료 (main도 안함) */
		}
		
		if(gender.equals("M")) {
			System.out.println("Male....");
		}else {
			System.out.println("Female....");
		}
		
		if(sum >= 90.0) {
			grade = "VIP";
		}else if(sum>=70.0) {
			grade = "GOLD";
		}else {
			grade = "SILVER";
		}
		
		System.out.printf("%s, %s, %f\n", grade, gender, sum);
		System.out.println("End.....");

	}

}
