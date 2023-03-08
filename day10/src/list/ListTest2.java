package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListTest2 {

	public static void main(String[] args) {
//		List<Integer> list = new List<Integer>(); // List는 인터페이스라서 오른쪽에 할 수 없다. 객체생성 불가
		List<Integer> list = new ArrayList<Integer>(); // 그래서 하위클래스인 ArrayList로 생성!!
		List<Integer> list2 = new LinkedList<Integer>(); // 방대한 용량 처리 가능
		
		// 1~10까지 숫자를 20개 입력 한다.
		// 단 while문을 이용한다.
		int size = 0;
//		while(size < 20) {
//			System.out.println("숫자를 입력하세요");
//			Scanner sc = new Scanner(System.in);
//			int num = sc.nextInt();
//			list.add(num);
//			size = list.size();
//		}

		while(list.size() < 20) {
			System.out.println("숫자를 입력하세요");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			list.add(num);
		}
		
		for (int i : list) {
			System.out.print(i+", ");
		}

	}

}
