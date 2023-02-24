package ifcontrol;

public class P84 {

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
			if(sum>=90) {
				grade = "MVIP";
			}else if(sum>=80) {
				grade = "MGOLD";
			}else
				grade = "MNORMAL";
		}else {
			if(sum>=90) {
				grade = "FVIP";
			}else if(sum>=80) {
				grade = "FGOLD";
			}else
				grade = "FNORMAL";		
		}
		
		switch(grade) {
			
		case "FVIP":
		case "MVIP" :
			sum += 100;
			break; /* 없으면 90점 밑에도 들어간다 */
		case "FGOLD":
		case "MGOLD" :
			sum += 90;
			break;
//		case "FNORMAL":
		default: // 모든 케이스가 아니면 다 일로 온다.
			sum += 10;
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
