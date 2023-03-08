package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListTest1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
//		list.add(30);
//		list.add(20);
//		list.add(10);
		
		//1~10까지 랜덤하게 담아라
		
		Random rd = new Random();
		
		for(int i = 0 ; i < 10 ; i++) {
			list.add(rd.nextInt(10)+1);
		}
		
		list.add(0, 100);
		list.remove(5);
		
		// 객체 타입과 primitive 타입이 왔다갔다 할 수 있다.
		for(int data : list) {
			System.out.println(data);
		}

	}

}
