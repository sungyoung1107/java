package ws0309;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		ArrayList<Integer> userNum = null;
		Lotto lotto = new Lotto();
		
		while(true) {
			// 로또 메뉴 고르기
			System.out.println("== 로또 생성기 입니다 ==");
			
			lotto.makeWinningNumberMoney(); // 당첨번호와 당첨금을 생성한다.
			try {
				System.out.println("== 1.로또번호 입력하기 / 2.나의 로또번호 조회하기 / 3.당첨금 및 등수 보기 / 4. 당첨번호 조회하기 / 5.나가기 중 1가지를 선택하세요 ==");
				menu = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("== 메뉴는 숫자로만 입력 가능합니다 ==");
				sc.next(); //엔터처리
			}
			
			switch(menu) {	
				case 1: userNum = lotto.getNumUser(); // 입력 받은 숫자 넣어준다.
						System.out.println("로또번호 생성완료! 2번을 눌러 조회해보세요! ");
						break;
				case 2: lotto.showNumber(userNum); // 사용자의 숫자를 보여준다.
						break;
				case 3: System.out.printf("금번 회차 총 당첨금은 %.0f원 입니다 \n", lotto.getPrizeMoney()); // 전체 당첨금을 보여준다.
						System.out.println("고객님의 등수는 "+ lotto.checkRanking(userNum)+"등 입니다"); // 등수를 보여준다.
						System.out.printf("고객님의 당첨금은 %.0f원 입니다 \n", lotto.prizeMoney(lotto.getGrade())); // 고객의 당첨금을 보여준다.
						break;
				case 4: System.out.println(lotto.getWinningNum()); // 당첨번호를 보여준다.
				case 5: break;	
			}
			
			if(menu==5) { // 5번인 경우만 나간다.
				System.out.println("== 게임을 종료합니다 ==");
				break;
			}
		}
		sc.close();	
	}
}
