package com.kbstar.hrd.app;

import java.util.Scanner;

import com.kbstar.hrd.Manager;

public class App2 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("추가하실 매니저 수를 입력하세요");
		int num = sc.nextInt();
		int cnt = 0;
		
		sc.nextLine();  // 엔터 처리 (newInt->nextLine 시에 필요)
		
		String[] str; // 매니저 입력 값을 처리할 배열
		Manager[] mns = new Manager[num]; // 매니저 수만큼 객체 배열 생성
		int j=0;
		
		while(true) {	
			System.out.println("매니저를 추가하세요 (ex) id:301, name:홍길동, salary:500, bonus:50): ");
			str = sc.nextLine().split(",");
				
			// 생성자의 argument 갯수(4) 검증
			if(str.length == 4) {
				mns[j] = new Manager(str[0].replace(",", "").trim(), str[1].replace(",", "").trim(), Integer.parseInt(str[2].replace(",", "").trim()), Integer.parseInt(str[3].replace(",", "").trim()));
				System.out.print("정상 입력 완료. ");
				cnt++;
				System.out.println(cnt + "개 입력되었습니다.");
				j++;
			}else {
					System.out.println("형식이 잘못 되었습니다.");
			}
			
			if(cnt==num)
				break;
		}	
		
//		System.out.println(str[0].replace(",", "").trim());
//		System.out.println(str[1].replace(",", "").trim());
//		System.out.println(str[2].replace(",", "").trim());
//		System.out.println(str[3].replace(",", "").trim());
		
		for(Manager data : mns) {
			System.out.println(data.toString());
			System.out.println("월급은 "+ data.getSalary());
			System.out.println("월급에 대한 세금은" + data.getTax());
			System.out.println("보너스는 " + data.getBonus());
			System.out.println("연봉은 "+ data.getAnnsSalary());
			System.out.println("연봉에 대한 세금은 "+ data.getAnnTax());
		}
		System.out.println("===========================");
		
		
		
	}
		
}

