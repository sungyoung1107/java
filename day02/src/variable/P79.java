package variable;

public class P79 {

	public static void main(String[] args) {
		int credit = 900;
		String grade = "";
//		if(credit >= 800) {
//			grade = "High";
//		} else {
//			grade = "Low";
//		}
//		System.out.println(grade);
	
		grade = credit >=800 ? "high" : "Low";
		System.out.println(grade);
	}

}
