package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.kbstar.DTO.UserDTO;

public class MapTest4 {

	public static void main(String[] args) {
		
		Map<String, UserDTO> db = new HashMap<String, UserDTO>();
		
		// UserDTO : id, pw, name
		db.put("id01", new UserDTO("id01", "pwd01", "james")); // id01 - pwd01, james
		db.put("id02", new UserDTO("id02", "pwd02", "james")); // id02 - pwd02, james
		db.put("id03", new UserDTO("id03", "pwd03", "james")); // id03 - pwd03, james
		
		// id02의 UserDTO
		UserDTO ud = db.get("id02");
		System.out.println(ud);
		
		
		UserDTO uu = new UserDTO("id02", "0000", "jame2");
		
		db.put(uu.getId(), uu);
		
		Collection<UserDTO> col = db.values(); // value 값 출력
		
		for (UserDTO user : col) {
			System.out.println(user);
		}
		
//		Set<String> keys = db.keySet();
//		System.(keys);
//		
		
	}

}
