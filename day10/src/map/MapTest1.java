package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest1 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");
		map.put(8, "E");
//		map.put(1, "A");
//		map.put(1, "A");
		
		System.out.println(map.size());
		System.out.println(map.containsKey(8)); // key값이 있니
		System.out.println(map.containsValue("D")); // value값이 있니
		
		System.out.println(map.get(3)); // 해당 key의 value값 반환
		
		Set<Integer> keys = map.keySet(); // key 값이 중복되면 안되니까 Set으로
		System.out.println(keys.toString());
		
		for(int data :keys) {
			System.out.println("key값은 " + data + ", value값은 " + map.get(data));
		}
		
//		for (int i, Stirng j : map) {
//			System.out.println()
//			System.out.println(map.get(i)); // 해당 key의 value값 반환
//		}
	}

}
