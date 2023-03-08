package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapTest2 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");
		map.put(8, "E");
		
		Collection<String> col = map.values(); //Collection은 list랑 set의 조상
		
		System.out.println(col.size());
		
		for(String data : col) {
			System.out.println(data);
		}

		
		
		
		
	}

}
