package ifcontrol;

import java.util.Scanner;

public class P93 {

	public static void main(String[] args) {
		//숫자를 4개를 입력 받는다.
		// 만약에 2자리 수가 아니면 프로그램 종료
		Scanner sc = new Scanner(System.in);		
		int ko = 0; //국어성적
		int en = 0; //영어성적
		int ma = 0; //수학성적
		int si = 0; //과학성적
			
		System.out.println("국어성적 입력 : ");
		ko = Integer.valueOf(sc.next());
		if(!(ko>=10 && ko<=99)) {
			sc.close();
			return;
		}
		
//		if(10 > ko || ko >= 100) {
//			sc.close();
//			return;
//		}
		
		System.out.println("영어성적 입력 : ");
		en = Integer.valueOf(sc.next());
		if(!(en>=10 && en<=99)) {
			sc.close();
			return;
		}
		
		System.out.println("수학성적 입력 : ");
		ma = Integer.valueOf(sc.next());
		if(!(ma>=10 && ma<=99)) {
			sc.close();
			return;
		}
		
		System.out.println("과학성적 입력 : ");
		si = Integer.valueOf(sc.next());
		if(!(si>=10 && si<=99)) {
			sc.close();
			return;
		}
		
		// 평균과 합계를 구한다.		
		// 평균 90점 이상이면 A
		// 평균 80점 이상이면 B
		// 평균 70점 이상이면 C
		// 평균 60점 이상이면 D
		// 평균 60점 미만이면 F
		
		// 평균, 합계, 학점을 출력하시오.
		
		double sum = ko + en + ma + si;
		double avg = (sum / 4);
		String grade ="";
		
		if (avg >= 90) {
			grade="A";
		}else if (avg >= 80) {
			grade="B";
		}else if (avg >= 70) {
			grade="C";
		}else if (avg >= 60) {
			grade="D";
		}else 
			grade="F";
		
		grade = (avg >= 90) ? "A": (avg >= 80) ? "B" : (avg >=70) ? "C" : (avg >=60 ) ? "D" : "F";
		
		
		System.out.printf("평균: %f 합계: %.0f 학점: %s", avg, sum, grade);
		System.out.println("평균은 "+ avg + "합계는 " + sum + "학점은 " + grade);
	
		sc.close();

		
	}

}
